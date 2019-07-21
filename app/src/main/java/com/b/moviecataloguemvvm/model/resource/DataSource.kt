package com.b.moviecataloguemvvm.model.resource

import androidx.lifecycle.LiveData
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.model.repository.remote.TvShowsDetail

interface DataSource {
    fun getMovie(): LiveData<List<ItemList>>
    fun getMovieDetail(movieId : String) : LiveData<ItemList>
    fun getTvShowsList(): LiveData<List<ItemList>>
    fun getTvShowsDetail(tvId:String) : LiveData<TvShowsDetail>
}