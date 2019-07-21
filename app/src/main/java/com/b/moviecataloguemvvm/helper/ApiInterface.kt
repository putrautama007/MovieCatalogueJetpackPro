package com.b.moviecataloguemvvm.helper

import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.model.repository.remote.ItemResponse
import com.b.moviecataloguemvvm.model.repository.remote.TvShowsDetail
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface ApiInterface {

    @GET("movie/now_playing")
    fun getMovie(@Query("api_key") apiKey: String?) : Call<ItemResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(@Path("movie_id") movieId: String? ,
                         @Query("api_key") apiKey: String?
                       ) : Call<ItemList>

    @GET("tv/popular")
    fun getTvShows(@Query("api_key") apiKey: String?) : Call<ItemResponse>


    @GET("tv/{tv_id}")
    fun getTvShowDetails(@Path("tv_id") tvId: String? ,
                         @Query("api_key") apiKey: String?
    ) : Call<TvShowsDetail>
}