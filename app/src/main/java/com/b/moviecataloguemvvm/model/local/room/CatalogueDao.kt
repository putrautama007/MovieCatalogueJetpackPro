package com.b.moviecataloguemvvm.model.local.room

import androidx.annotation.WorkerThread
import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import androidx.room.*
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel

@Dao
interface CatalogueDao {
    @Transaction
    @Query("SELECT * FROM moviemodel WHERE movieId = :movieId")
    fun getMovieById(movieId: Int): LiveData<MovieModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movie: List<MovieModel>): LongArray

    @Update(onConflict = OnConflictStrategy.FAIL)
    fun updateMovie(movie: MovieModel): Int

    @WorkerThread
    @Query("SELECT * FROM moviemodel where favorite = 1")
    fun getMovies(): LiveData<List<MovieModel>>

    @Query("SELECT * FROM moviemodel where favorite = 1")
    fun getMovieAsPaged(): DataSource.Factory<Int, MovieModel>




    @Transaction
    @Query("SELECT * FROM tvshowmodel WHERE tvShowId = :tvShowId")
    fun getTvShowById(tvShowId: Int): LiveData<TvShowModel>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertTvShow(tvShow: List<TvShowModel>): LongArray

    @Update(onConflict = OnConflictStrategy.FAIL)
    fun updateTvShow(tvShow: TvShowModel): Int

    @WorkerThread
    @Query("SELECT * FROM tvshowmodel where favorite = 1")
    fun getTvShows(): LiveData<List<TvShowModel>>

    @Query("SELECT * FROM tvshowmodel where favorite = 1")
    fun getTvShowAsPaged(): DataSource.Factory<Int, TvShowModel>
}