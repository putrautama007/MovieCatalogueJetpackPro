package com.b.moviecataloguemvvm.di

import android.app.Application
import com.b.moviecataloguemvvm.model.repository.DataRepository
import com.b.moviecataloguemvvm.model.repository.local.LocalRepository
import com.b.moviecataloguemvvm.model.repository.remote.RemoteRepository

object Injection {
    fun movieRepository(): DataRepository?{
        val localRepository= LocalRepository()
        val remoteRepository = RemoteRepository.getInstance()
        return DataRepository.getInstance(localRepository,remoteRepository)
    }
}