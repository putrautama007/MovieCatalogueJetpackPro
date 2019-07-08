package com.b.moviecataloguemvvm.viewmodel

import androidx.lifecycle.ViewModel
import com.b.moviecataloguemvvm.model.Data
import com.b.moviecataloguemvvm.model.TvShowModel

class TvShowViewModel: ViewModel() {
    val tvShow : List<TvShowModel> = Data.generateTvShow()
    fun tvShowDetail (id : Int): TvShowModel? = Data.tvShowDetail(id)
}