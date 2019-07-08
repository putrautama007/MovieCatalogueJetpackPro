package com.b.moviecataloguemvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.b.moviecataloguemvvm.model.Data
import com.b.moviecataloguemvvm.model.MovieModel

class MovieViewModel: ViewModel() {
    val movies : List<MovieModel> = Data.generateMovies()
    fun movieDetail (id : Int): MovieModel? = Data.movieDetail(id)
}