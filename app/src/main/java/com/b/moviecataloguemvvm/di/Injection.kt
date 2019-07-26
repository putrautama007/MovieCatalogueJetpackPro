package com.b.moviecataloguemvvm.di

import android.app.Application
import com.b.moviecataloguemvvm.helper.ApiClient
import com.b.moviecataloguemvvm.model.repository.DataRepository
import com.b.moviecataloguemvvm.model.repository.local.LocalRepository
import com.b.moviecataloguemvvm.model.repository.remote.RemoteRepository
import com.b.moviecataloguemvvm.model.repository.remote.RemoteRepositoryJava

object Injection {
    fun movieRepository(): DataRepository?{
        val localRepository= LocalRepository()
        val remoteRepository = RemoteRepositoryJava.getInstance(ApiClient)
        return DataRepository.getInstance(localRepository,remoteRepository)
    }
}