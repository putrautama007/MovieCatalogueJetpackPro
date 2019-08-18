package com.b.moviecataloguemvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MediatorLiveData
import com.b.moviecataloguemvvm.model.remote.APIResponse
import com.b.moviecataloguemvvm.model.remote.StatusResponse
import com.b.moviecataloguemvvm.utils.AppExecutors
import com.b.moviecataloguemvvm.vo.Resource

abstract class NetworkBoundResource<ResultType, RequestType>(private val executors: AppExecutors) {

    private val result = MediatorLiveData<Resource<ResultType>>()

    private fun onFetchFailed() {}

    protected abstract fun loadDataFromDB(): LiveData<ResultType>

    protected abstract fun  shouldFetch(data: ResultType): Boolean?

    protected abstract fun createCall(): LiveData<APIResponse<RequestType>>?

    protected abstract fun saveCallResult(data: RequestType)

    protected fun fetchFromNetwork(dbSource: LiveData<ResultType>){
        val apiResponse = createCall()

        result.addSource(dbSource){
            newData -> result.setValue(Resource.loading(newData))
        }
        result.addSource(apiResponse!!){
            response ->
            result.removeSource(apiResponse)
            result.removeSource(dbSource)

            when (response.statusResponse) {
                StatusResponse.SUCCESS -> executors.diskIO().execute {

                    response.body?.let { saveCallResult(it) }

                    executors.mainThread().execute {
                        result.addSource(loadDataFromDB()
                        ) { newData -> result.setValue(Resource.success(newData)) }
                    }

                }

                StatusResponse.EMPTY -> executors.mainThread().execute {
                    result.addSource(loadDataFromDB()
                    ) { newData -> result.setValue(Resource.success(newData)) }
                }
                StatusResponse.ERROR -> {
                    onFetchFailed()
                    result.addSource(
                        dbSource
                    ) { newData -> result.setValue(response.message?.let { Resource.error(it, newData) }) }
                }
            }
        }
    }

    fun asLiveData() : LiveData<Resource<ResultType>>{
        return result
    }

    init {
        result.value = Resource.loading(null)

        val dbSource = loadDataFromDB()

        result.addSource(dbSource){data ->
            result.removeSource(dbSource)
            if (shouldFetch(data)!!) fetchFromNetwork(dbSource)
            else result.addSource(dbSource){
                newData -> result.setValue(Resource.success(newData))
            }
        }
    }
}