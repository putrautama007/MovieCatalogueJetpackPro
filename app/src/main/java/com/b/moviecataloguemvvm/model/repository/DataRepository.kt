package com.b.moviecataloguemvvm.model.repository

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.b.moviecataloguemvvm.model.repository.local.LocalRepository
import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.model.repository.remote.RemoteRepository
import com.b.moviecataloguemvvm.model.repository.remote.TvShowsDetail
import com.b.moviecataloguemvvm.model.resource.DataSource

open class DataRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) :
    DataSource {
    override fun getTvShowsDetail(tvId: String): LiveData<TvShowsDetail> {
        val tvShowDetail = MutableLiveData<TvShowsDetail>()
        remoteRepository.getMovieDetail(tvId,object  : GetTvShowDetailCallback{
            override fun onResponse(tvShowsResponse: TvShowsDetail) {
                tvShowDetail.postValue(tvShowsResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }

        })
        return tvShowDetail
    }

    override fun getMovieDetail(movieId: String): LiveData<ItemList> {
        val movieDetail = MutableLiveData<ItemList>()
        remoteRepository.getMovieDetail(movieId,object  : GetMovieDetailCallback{
            override fun onResponse(movieResponse: ItemList) {
                movieDetail.postValue(movieResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }

        })
        return movieDetail
    }


    override fun getMovie(): LiveData<List<ItemList>> {
        val movieLists = MutableLiveData<List<ItemList>>()
        remoteRepository.getMovie(object  : GetMovieCallback{
            override fun onResponse(movieResponse: List<ItemList>) {
                Log.d("movie", movieResponse.toString())
                movieLists.postValue(movieResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }
        })
        return movieLists
    }


    override fun getTvShowsList(): LiveData<List<ItemList>> {
        val tvShowsLists = MutableLiveData<List<ItemList>>()

        remoteRepository.getTvShowsList(object : GetTvShowsCallback {
            override fun onResponse(tvShowsResponse: List<ItemList>) {
                tvShowsLists.postValue(tvShowsResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }

        })
        return  tvShowsLists
    }

    companion object {
        @Volatile
        private var INSTANCE: DataRepository? = null

        fun getInstance(localeRepository: LocalRepository, remoteRepository: RemoteRepository): DataRepository? {
            if (INSTANCE == null) {
                synchronized(DataRepository::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            DataRepository(localeRepository, remoteRepository)
                    }
                }
            }
            return INSTANCE
        }
    }
}