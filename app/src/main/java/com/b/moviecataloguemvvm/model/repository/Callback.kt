package com.b.moviecataloguemvvm.model.repository

import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.model.repository.remote.TvShowsDetail


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