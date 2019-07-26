package com.b.moviecataloguemvvm.model.repository.remote

import android.os.Handler
import android.util.Log
import com.b.moviecataloguemvvm.BuildConfig
import com.b.moviecataloguemvvm.helper.ApiClient
import com.b.moviecataloguemvvm.utils.EspressoIdlingResource
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


open class RemoteRepository {
    private val request = ApiClient.create()


    fun getMovie(getMovieListCallback: GetMovieCallback){
        EspressoIdlingResource.increment()
        val responseHandler = Handler()
        responseHandler.postDelayed({
            request.getMovie(BuildConfig.MOVIE_API).enqueue(object : Callback<ItemResponse>{
                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                    Log.d("error",t.toString())
                }

                override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                    getMovieListCallback.onResponse(response.body()?.results!!)
                }

            })

        }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getMovieDetail(movieId: String,getMovieDetailCallback: GetMovieDetailCallback){
        EspressoIdlingResource.increment()
        val responseHandler = Handler()
        responseHandler.postDelayed({
            request.getMovieDetails(movieId,BuildConfig.MOVIE_API).enqueue(object : Callback<ItemList>{
                override fun onFailure(call: Call<ItemList>, t: Throwable) {
                    Log.d("error",t.toString())
                }

                override fun onResponse(call: Call<ItemList>, response: Response<ItemList>) {
                    response.body()?.let { getMovieDetailCallback.onResponse(it) }
                }

            })

        }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getTvShowsList(getTvShowsCallback: GetTvShowsCallback){
        EspressoIdlingResource.increment()
        val responseHandler = Handler()
        responseHandler.postDelayed({
            request.getTvShows(BuildConfig.MOVIE_API).enqueue(object : Callback<ItemResponse>{
                override fun onFailure(call: Call<ItemResponse>, t: Throwable) {
                    Log.d("error",t.toString())
                }

                override fun onResponse(call: Call<ItemResponse>, response: Response<ItemResponse>) {
                    response.body()?.let { getTvShowsCallback.onResponse(response.body()?.results!!) }
                }

            })
            EspressoIdlingResource.decrement()
        }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getMovieDetail(tvId: String,getTvShowDetailCallback: GetTvShowDetailCallback){
        EspressoIdlingResource.increment()
        val responseHandler = Handler()
        responseHandler.postDelayed({
            request.getTvShowDetails(tvId,BuildConfig.MOVIE_API).enqueue(object : Callback<TvShowsDetail>{
                override fun onFailure(call: Call<TvShowsDetail>, t: Throwable) {
                    Log.d("error",t.toString())
                }

                override fun onResponse(call: Call<TvShowsDetail>, response: Response<TvShowsDetail>) {
                    response.body()?.let { getTvShowDetailCallback.onResponse(it) }
                }

            })

        }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getMovieCrew(movieId: String,getMovieCrewCallback: GetMovieCrewCallback ){
        EspressoIdlingResource.increment()
        val responseHandler = Handler()
        responseHandler.postDelayed({
            request.getMovieCrew(movieId,BuildConfig.MOVIE_API).enqueue(object : Callback<CrewResponse>{
                override fun onFailure(call: Call<CrewResponse>, t: Throwable) {
                    Log.d("error",t.toString())
                }

                override fun onResponse(call: Call<CrewResponse>, response: Response<CrewResponse>) {
                    response.body()?.let { getMovieCrewCallback.onResponse(response.body()?.crew!!) }
                }

            })

        }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    fun getTvShowCrew(tvId: String,getTvShowCrewCallback: GetTvShowCrewCallback ){
        EspressoIdlingResource.increment()
        val responseHandler = Handler()
        responseHandler.postDelayed({
            request.getMovieCrew(tvId,BuildConfig.MOVIE_API).enqueue(object : Callback<CrewResponse>{
                override fun onFailure(call: Call<CrewResponse>, t: Throwable) {
                    Log.d("error",t.toString())
                }

                override fun onResponse(call: Call<CrewResponse>, response: Response<CrewResponse>) {
                    response.body()?.let { getTvShowCrewCallback.onResponse(response.body()?.crew!!) }
                }

            })

        }, SERVICE_LATENCY_IN_MILLIS
        )
    }

    interface GetMovieCallback{
        fun onResponse(movieResponse : List<ItemList>)
        fun onErrorResponse()
    }
    interface GetMovieDetailCallback{
        fun onResponse(movieResponse : ItemList)
        fun onErrorResponse()
    }
    interface GetTvShowsCallback{
        fun onResponse(tvShowsResponse : List<ItemList>)
        fun onErrorResponse()
    }
    interface GetTvShowDetailCallback{
        fun onResponse(tvShowsResponse : TvShowsDetail)
        fun onErrorResponse()
    }
    interface GetMovieCrewCallback{
        fun onResponse(movieResponse : List<CrewList>)
        fun onErrorResponse()
    }
    interface GetTvShowCrewCallback{
        fun onResponse(tvShowsResponse : List<CrewList>)
        fun onErrorResponse()
    }

    companion object {

        private const val SERVICE_LATENCY_IN_MILLIS: Long = 2000
        private var INSTANCE: RemoteRepository? = null

        fun getInstance(): RemoteRepository {
            if (INSTANCE == null) {
                INSTANCE =
                    RemoteRepository()
            }
            return INSTANCE!!
        }
    }
}