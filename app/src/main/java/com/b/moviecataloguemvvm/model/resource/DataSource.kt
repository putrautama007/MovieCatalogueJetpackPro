package com.b.moviecataloguemvvm.model.resource

import androidx.lifecycle.LiveData
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel

interface DataSource {
    fun getMovieList(): LiveData<List<MovieModel>>
    fun getTvShowsList(): LiveData<List<TvShowModel>>
}