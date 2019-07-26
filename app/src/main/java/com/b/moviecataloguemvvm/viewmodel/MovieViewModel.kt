package com.b.moviecataloguemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.b.moviecataloguemvvm.model.repository.DataRepository
import com.b.moviecataloguemvvm.model.repository.remote.CrewList
import com.b.moviecataloguemvvm.model.repository.remote.ItemList

class MovieViewModel(private val dataRepository: DataRepository): ViewModel() {
    val movie : LiveData<List<ItemList>> = dataRepository.getMovie()
    fun getMovieDetail(movieId: String) : LiveData<ItemList> = dataRepository.getMovieDetail(movieId)
    fun getMovieCrew(movieId: String): LiveData<List<CrewList>> = dataRepository.getMovieCrew(movieId)
}