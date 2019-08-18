package com.b.moviecataloguemvvm.model.local.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel

@Database(entities = [MovieModel::class, TvShowModel::class],version = 1, exportSchema = false)
abstract class CatalogueDatabase: RoomDatabase() {
    abstract fun catalogueDao(): CatalogueDao

    companion object{
        private var INSTANCE: CatalogueDatabase? = null

        private val sLock = Any()

        fun getInstance(context: Context): CatalogueDatabase {
            synchronized(sLock) {
                if (INSTANCE == null) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        CatalogueDatabase::class.java, "catalogue.db"
                    )
                        .build()
                }
                return INSTANCE as CatalogueDatabase
            }
        }
    }
}