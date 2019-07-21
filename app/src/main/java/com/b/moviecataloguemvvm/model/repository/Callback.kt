package com.b.moviecataloguemvvm.model.repository

import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel


interface GetMovieListCallback{
    fun onMovieResponse(movieResponse : List<MovieModel>)
    fun onErrorResponse()
}
interface GetTvShowsCallback{
    fun onMovieResponse(tvShowsResponse : List<TvShowModel>)
    fun onErrorResponse()
}