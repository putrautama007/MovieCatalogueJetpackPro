package com.b.moviecataloguemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.repository.DataRepository

class MovieViewModel(dataRepository: DataRepository): ViewModel() {
    val movies : LiveData<List<MovieModel>> = dataRepository.getMovieList()
}