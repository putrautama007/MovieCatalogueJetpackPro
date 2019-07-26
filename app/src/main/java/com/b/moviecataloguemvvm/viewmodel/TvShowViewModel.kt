package com.b.moviecataloguemvvm.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.model.repository.DataRepository
import com.b.moviecataloguemvvm.model.repository.remote.CrewList
import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.model.repository.remote.TvShowsDetail

class TvShowViewModel(private val dataRepository: DataRepository): ViewModel() {
    val tvShow : LiveData<List<ItemList>> = dataRepository.getTvShowsList()
    fun getTvShowDetail(tvId: String) : LiveData<TvShowsDetail> = dataRepository.getTvShowsDetail(tvId)
    fun getTvShowCrew(tvId: String): LiveData<List<CrewList>> = dataRepository.getTvShowsCrew(tvId)

}