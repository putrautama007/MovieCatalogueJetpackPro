package com.b.moviecataloguemvvm.model.repository.remote

import android.os.Handler
import com.b.moviecataloguemvvm.model.repository.GetMovieListCallback
import com.b.moviecataloguemvvm.model.repository.GetTvShowsCallback
import com.b.moviecataloguemvvm.utils.EspressoIdlingResource


open class RemoteRepository(private val helper: Helper) {

    fun getMovieList(getMovieListCallback: GetMovieListCallback){
        EspressoIdlingResource.increment()
        val responseHandler = Handler()
        responseHandler.postDelayed({
            getMovieListCallback.onMovieResponse(helper.loadMovieData())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS
        )
    }


    fun getTvShowsList(getTvShowsCallback: GetTvShowsCallback){
        EspressoIdlingResource.increment()
        val responseHandler = Handler()
        responseHandler.postDelayed({
            getTvShowsCallback.onMovieResponse(helper.loadTvShowsData())
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000
        private var INSTANCE: RemoteRepository? = null

        fun getInstance(helper: Helper): RemoteRepository {
            if (INSTANCE == null) {
                INSTANCE =
                    RemoteRepository(helper)
            }
            return INSTANCE!!
        }
    }
}