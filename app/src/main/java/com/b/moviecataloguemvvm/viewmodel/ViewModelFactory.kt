package com.b.moviecataloguemvvm.viewmodel

import android.app.Application
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.b.moviecataloguemvvm.di.Injection
import com.b.moviecataloguemvvm.model.repository.DataRepository

@Suppress("UNCHECKED_CAST")
class ViewModelFactory(private val dataRepository: DataRepository) : ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(factoryClass: Class<T>) :T{
        return  when{
            factoryClass.isAssignableFrom(MovieViewModel::class.java) -> MovieViewModel(dataRepository) as T
            factoryClass.isAssignableFrom(TvShowViewModel::class.java) -> TvShowViewModel(dataRepository) as T
            else -> throw IllegalArgumentException("Unknown ViewModel: " + factoryClass.name)
        }
    }

    companion object {
        @Volatile
        private var INSTANCE: ViewModelFactory? = null

        fun getInstance(application: Application): ViewModelFactory? {
            if (INSTANCE == null) {
                synchronized(ViewModelFactory::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE = Injection.movieRepository(application)?.let { ViewModelFactory(it) }
                    }
                }
            }
            return INSTANCE
        }

    }
}