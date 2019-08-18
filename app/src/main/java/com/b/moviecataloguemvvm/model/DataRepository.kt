package com.b.moviecataloguemvvm.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.paging.LivePagedListBuilder
import androidx.paging.PagedList
import com.b.moviecataloguemvvm.model.local.LocalRepository
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel
import com.b.moviecataloguemvvm.model.remote.APIResponse
import com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava
import com.b.moviecataloguemvvm.model.remote.response.MovieModelResponse
import com.b.moviecataloguemvvm.model.remote.response.TvShowModelResponse
import com.b.moviecataloguemvvm.utils.AppExecutors
import com.b.moviecataloguemvvm.vo.Resource
import java.util.ArrayList


open class DataRepository private constructor(
    private val localRepository: LocalRepository,
    private val remoteRepositoryJava: com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava,
    val executors: AppExecutors
): DataSource {
    override fun getMovies(): LiveData<Resource<List<MovieModel>>> {
        return object : NetworkBoundResource<List<MovieModel>, List<MovieModelResponse>>(executors) {

            override fun loadDataFromDB(): LiveData<List<MovieModel>> {
                return  localRepository.getMovies()
            }
            override fun shouldFetch(data: List<MovieModel>): Boolean? {
                return false
            }

            override fun createCall(): LiveData<APIResponse<List<MovieModelResponse>>>? {
                return null
            }

            override fun saveCallResult(data: List<MovieModelResponse>) {

            }
        }.asLiveData()
    }

    override fun getMovie(movieId: Int): LiveData<Resource<MovieModel>> {
        return object : NetworkBoundResource<MovieModel, MovieModelResponse>(executors) {

            override fun loadDataFromDB(): LiveData<MovieModel> {
                return localRepository.getMovieById(movieId)
            }

            override fun shouldFetch(data: MovieModel): Boolean? {
                return false
            }

            override fun createCall(): LiveData<APIResponse<MovieModelResponse>> ?{
                return null
            }

            override fun saveCallResult(data: MovieModelResponse) {

            }
        }.asLiveData()
    }

    override fun setFavoriteMovie(movie: MovieModel, isFavorite: Boolean) {
        val runnable = { localRepository.setFavoriteMovie(movie, isFavorite) }
        executors.diskIO().execute(runnable)
    }

    override fun insertMovies(movies: List<MovieModel>) {
        val runnable = {
            if(localRepository.getMovies().value.isNullOrEmpty()){
                localRepository.insertMovies(movies)
            }
        }
        executors.diskIO().execute(runnable)
    }

    override fun getMovieAsPaged(): LiveData<Resource<PagedList<MovieModel>>> {
        return object : NetworkBoundResource<PagedList<MovieModel>, List<MovieModelResponse>>(executors) {

            override fun loadDataFromDB(): LiveData<PagedList<MovieModel>> {
                return LivePagedListBuilder(
                    localRepository.getMovieAsPaged(),
                    20
                ).build()
            }

            override fun shouldFetch(data: PagedList<MovieModel>): Boolean? {
                return false
            }

            override fun createCall(): LiveData<APIResponse<List<MovieModelResponse>>>? {
                return null
            }

            override fun saveCallResult(data: List<MovieModelResponse>) {

            }
        }.asLiveData()
    }

    override fun getTvShows(): LiveData<Resource<List<TvShowModel>>> {
        return object : NetworkBoundResource<List<TvShowModel>, List<TvShowModelResponse>>(executors) {

            override fun loadDataFromDB(): LiveData<List<TvShowModel>> {
                return localRepository.getTvShows()
            }

            override fun shouldFetch(data: List<TvShowModel>): Boolean? {
                return false
            }

            override fun createCall(): LiveData<APIResponse<List<TvShowModelResponse>>>? {
                return null
            }

            override fun saveCallResult(data: List<TvShowModelResponse>) {

            }
        }.asLiveData()
    }

    override fun getTvShow(tvShowId: Int): LiveData<Resource<TvShowModel>> {
        return object : NetworkBoundResource<TvShowModel, TvShowModelResponse>(executors) {

            override fun loadDataFromDB(): LiveData<TvShowModel> {
                return localRepository.getTvShowById(tvShowId)
            }

            override fun shouldFetch(data: TvShowModel): Boolean? {
                return false
            }

            override fun createCall(): LiveData<APIResponse<TvShowModelResponse>>? {
                return null
            }

            override fun saveCallResult(data: TvShowModelResponse) {

            }
        }.asLiveData()
    }

    override fun setFavoriteTvShow(tvShow: TvShowModel, isFavorite: Boolean) {
        val runnable = { localRepository.setFavoriteTvShow(tvShow, isFavorite) }
        executors.diskIO().execute(runnable)
    }

    override fun insertTvShows(tvShows: List<TvShowModel>) {
        val runnable = {
            if(localRepository.getTvShows().value.isNullOrEmpty()){
                localRepository.insertTvShows(tvShows)
            }
        }
        executors.diskIO().execute(runnable)
    }

    override fun getTvShowAsPaged(): LiveData<Resource<PagedList<TvShowModel>>> {
        return object : NetworkBoundResource<PagedList<TvShowModel>, List<TvShowModelResponse>>(executors) {

            override fun loadDataFromDB(): LiveData<PagedList<TvShowModel>> {
                return LivePagedListBuilder(
                    localRepository.getTvShowAsPaged(),
                    20
                ).build()
            }

            override fun shouldFetch(data: PagedList<TvShowModel>): Boolean? {
                return false
            }

            override fun createCall(): LiveData<APIResponse<List<TvShowModelResponse>>>? {
                return null
            }

            override fun saveCallResult(data: List<TvShowModelResponse>) {

            }
        }.asLiveData()
    }

    override fun getMovieList(): LiveData<List<MovieModel>> {
        val moviesMutable = MutableLiveData<List<MovieModel>>()

        remoteRepositoryJava.getMovieList(object : com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetMovieListCallback {
            override fun onMoviesReceived(movieResponseList: List<MovieModelResponse>) {
                val movies = ArrayList<MovieModel>()
                for (i in movieResponseList.indices) {
                    val response = movieResponseList[i]
                    val movie = MovieModel(
                        movieId = response.movieId,
                        movieTitle = response.movieTitle,
                        movieDescription = response.movieDescription,
                        movieRelease = response.movieRelease,
                        movieRating = response.movieRating,
                        moviePoster = response.moviePoster,
                        movieTrailer = response.movieTrailer,
                        featuredCrew = response.featuredCrew
                    )
                    movies.add(movie)
                }
                moviesMutable.postValue(movies)
            }

            override fun onDataNotAvailable() {
                //
            }

        })
        return moviesMutable
    }

    override fun getMovieById(id: Int): LiveData<MovieModel> {
        val moviesMutable = MutableLiveData<MovieModel>()

        remoteRepositoryJava.getMovieById(id, object : com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetMovieByIdCallback {
            override fun onMovieReceived(movieResponse: MovieModelResponse) {
                val movie = MovieModel(
                    movieId = movieResponse.movieId,
                    movieTitle = movieResponse.movieTitle,
                    movieDescription = movieResponse.movieDescription,
                    movieRelease = movieResponse.movieRelease,
                    movieRating = movieResponse.movieRating,
                    moviePoster = movieResponse.moviePoster,
                    movieTrailer = movieResponse.movieTrailer,
                    featuredCrew = movieResponse.featuredCrew
                )
                moviesMutable.postValue(movie)
            }

            override fun onDataNotAvailable() {
                //
            }

        })
        return moviesMutable

    }

    override fun getTvShowList(): LiveData<List<TvShowModel>> {
        val tvShowsMutable = MutableLiveData<List<TvShowModel>>()

        remoteRepositoryJava.getTvShowList(object : com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetTvShowListCallback {
            override fun onTvShowsReceived(tvShowResponseList: List<TvShowModelResponse>) {
                val tvShows = ArrayList<TvShowModel>()
                for (i in tvShowResponseList.indices) {
                    val response = tvShowResponseList[i]
                    val tvShow = TvShowModel(
                        tvShowId = response.tvShowId,
                        tvShowTitle = response.tvShowTitle,
                        tvShowDescription = response.tvShowDescription,
                        tvShowRelease = response.tvShowRelease,
                        tvShowRating = response.tvShowRating,
                        tvShowPoster = response.tvShowPoster,
                        tvShowTrailer = response.tvShowTrailer,
                        featuredCrew = response.featuredCrew
                    )
                    tvShows.add(tvShow)
                }
                tvShowsMutable.postValue(tvShows)
            }

            override fun onDataNotAvailable() {

            }

        })
        return tvShowsMutable
    }

    override fun getTvShowById(tvShowId: Int): LiveData<TvShowModel> {
        val tvShowsMutable = MutableLiveData<TvShowModel>()

        remoteRepositoryJava.getTvShowById(tvShowId, object : com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetTvShowByIdCallback {
            override fun onTvShowReceived(tvShowResponse: TvShowModelResponse) {
                val tvShow = TvShowModel(
                    tvShowId = tvShowResponse.tvShowId,
                    tvShowTitle = tvShowResponse.tvShowTitle,
                    tvShowDescription = tvShowResponse.tvShowDescription,
                    tvShowRelease = tvShowResponse.tvShowRelease,
                    tvShowRating = tvShowResponse.tvShowRating,
                    tvShowPoster = tvShowResponse.tvShowPoster,
                    tvShowTrailer = tvShowResponse.tvShowTrailer,
                    featuredCrew = tvShowResponse.featuredCrew
                )
                tvShowsMutable.postValue(tvShow)
            }

            override fun onDataNotAvailable() {

            }

        })
        return tvShowsMutable
    }

    companion object {

        @Volatile
        private var INSTANCE: DataRepository? = null

        fun getInstance(local: LocalRepository, remote: com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava, appExecutors: AppExecutors): DataRepository? {
            if (INSTANCE == null) {
                synchronized(DataRepository::class.java) {
                    if (INSTANCE == null) {
                        INSTANCE =
                            DataRepository(local, remote, appExecutors)
                    }
                }
            }
            return INSTANCE
        }
    }
}