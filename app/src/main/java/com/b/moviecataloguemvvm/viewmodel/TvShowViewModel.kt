package com.b.moviecataloguemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.model.repository.DataRepository

class TvShowViewModel(dataRepository: DataRepository): ViewModel() {
    val tvShow : LiveData<List<TvShowModel>> = dataRepository.getTvShowsList()

}