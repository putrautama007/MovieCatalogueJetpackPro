package com.b.moviecataloguemvvm.di

import android.app.Application
import com.b.moviecataloguemvvm.model.DataRepository
import com.b.moviecataloguemvvm.model.local.LocalRepository
import com.b.moviecataloguemvvm.model.local.room.CatalogueDatabase
import com.b.moviecataloguemvvm.model.remote.Helper
import com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava
import com.b.moviecataloguemvvm.utils.AppExecutors

object Injection {
    fun provideDataRepository(application: Application) : DataRepository?{
        val localRepository = LocalRepository(
            CatalogueDatabase.getInstance(application).catalogueDao()
        )
        val remoteRepository = RemoteRepositoryJava.getInstance(
            Helper(
                application
            )
        )
        val executors = AppExecutors()
        return DataRepository.getInstance(localRepository,remoteRepository, executors)
    }
}