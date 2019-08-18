package com.b.moviecataloguemvvm.model.local

import androidx.lifecycle.LiveData
import androidx.paging.DataSource
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel
import com.b.moviecataloguemvvm.model.local.room.CatalogueDao

open class LocalRepository constructor(private val catalogueDao: CatalogueDao){
    fun getMovies(): LiveData<List<MovieModel>> = catalogueDao.getMovies()

    fun getMovieById(movieId: Int): LiveData<MovieModel> = catalogueDao.getMovieById(movieId)

    fun insertMovies(movies:List<MovieModel>){
        catalogueDao.insertMovies(movies)
    }

    fun setFavoriteMovie(movie: MovieModel, isFavorite:Boolean){
        movie.favorite = isFavorite
        catalogueDao.updateMovie(movie)
    }

    fun getMovieAsPaged(): DataSource.Factory<Int, MovieModel> {
        return catalogueDao.getMovieAsPaged()
    }


    fun getTvShows(): LiveData<List<TvShowModel>> = catalogueDao.getTvShows()

    fun getTvShowById(tvShowId: Int): LiveData<TvShowModel> = catalogueDao.getTvShowById(tvShowId)

    fun insertTvShows(tvShows:List<TvShowModel>){
        catalogueDao.insertTvShow(tvShows)
    }

    fun setFavoriteTvShow(tvShow: TvShowModel, isFavorite:Boolean){
        tvShow.favorite = isFavorite
        catalogueDao.updateTvShow(tvShow)
    }

    fun getTvShowAsPaged(): DataSource.Factory<Int, TvShowModel> {
        return catalogueDao.getTvShowAsPaged()
    }

    companion object {

        private var INSTANCE: LocalRepository? = null

        fun getInstance(catalogueDao: CatalogueDao): LocalRepository {
            if (INSTANCE == null) {
                INSTANCE =
                    LocalRepository(catalogueDao)
            }
            return INSTANCE as LocalRepository
        }
    }
}