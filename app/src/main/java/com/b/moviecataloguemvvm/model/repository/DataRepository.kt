package com.b.moviecataloguemvvm.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.b.moviecataloguemvvm.model.MovieModel
import com.b.moviecataloguemvvm.model.TvShowModel
import com.b.moviecataloguemvvm.model.repository.local.LocalRepository
import com.b.moviecataloguemvvm.model.repository.remote.RemoteRepository
import com.b.moviecataloguemvvm.model.resource.DataSource

open class DataRepository(private val localRepository: LocalRepository, private val remoteRepository: RemoteRepository) :
    DataSource {

    override fun getMovieList(): LiveData<List<MovieModel>> {
        val movieLists = MutableLiveData<List<MovieModel>>()

        remoteRepository.getMovieList(object : GetMovieListCallback{
            override fun onMovieResponse(movieResponse: List<MovieModel>) {
                val movieItems = ArrayList<MovieModel>()
                for (movie in movieResponse.indices){
                    val response =  movieResponse[movie]
                    val movieData = MovieModel(
                        response.movieId,
                        response.movieTitle,
                        response.movieDescription,
                        response.moviePoster,
                        response.movieRelease,
                        response.movieRating,
                        response.movieTrailer,
                        response.featuredCrew
                    )
                    movieItems.add(movieData)
                }
                movieLists.postValue(movieItems)
            }
            override fun onErrorResponse() {
                print("error to get movies")
            }

        })
        return  movieLists
    }


    override fun getTvShowsList(): LiveData<List<TvShowModel>> {
        val tvShowsLists = MutableLiveData<List<TvShowModel>>()

        remoteRepository.getTvShowsList(object : GetTvShowsCallback {
            override fun onMovieResponse(tvShowsResponse: List<TvShowModel>) {
                val tvShowsItems = ArrayList<TvShowModel>()
                for (tvShows in tvShowsResponse.indices){
                    val response =  tvShowsResponse[tvShows]
                    val tvShowsData = TvShowModel(
                        response.tvShowId,
                        response.tvShowTitle,
                        response.tvShowDescription,
                        response.tvShowPoster,
                        response.tvShowRelease,
                        response.tvShowRating,
                        response.tvShowTrailer,
                        response.featuredCrew
                    )
                    tvShowsItems.add(tvShowsData)
                }
                tvShowsLists.postValue(tvShowsItems)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }

        })
        return  tvShowsLists
    }

    companion object {
        @Volatile
        private var INSTANCE: DataRepository? = null

        fun getInstance(localeRepository: LocalRepository, remoteRepository: RemoteRepository): DataRepository? {
            if (INSTANCE == null) {
                synchronized(DataRepository::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            DataRepository(localeRepository, remoteRepository)
                    }
                }
            }
            return INSTANCE
        }
    }
}