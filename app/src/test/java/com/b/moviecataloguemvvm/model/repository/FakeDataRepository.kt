package com.b.moviecataloguemvvm.model.repository

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.b.moviecataloguemvvm.model.repository.local.LocalRepository
import com.b.moviecataloguemvvm.model.repository.remote.*
import com.b.moviecataloguemvvm.model.resource.DataSource

open class FakeDataRepository (private val localRepository: LocalRepository, private val remoteRepository: RemoteRepositoryJava) :
    DataSource {
    override fun getMovieCrew(movieId: String): LiveData<List<CrewList>> {
        val movieCrewList = MutableLiveData<List<CrewList>>()
        remoteRepository.getMovieCrew(movieId,object : RemoteRepositoryJava.GetMovieCrewCallback {
            override fun onResponse(movieResponse: List<CrewList>) {
                movieCrewList.postValue(movieResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }

        })
        return  movieCrewList
    }

    override fun getTvShowsCrew(tvId: String): LiveData<List<CrewList>> {
        val tvShowsCrewList = MutableLiveData<List<CrewList>>()
        remoteRepository.getTvShowCrew(tvId,object : RemoteRepositoryJava.GetTvShowCrewCallback {
            override fun onResponse(tvShowsResponse: List<CrewList>) {
                tvShowsCrewList.postValue(tvShowsResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }


        })
        return  tvShowsCrewList
    }

    override fun getTvShowsDetail(tvId: String): LiveData<TvShowsDetail> {
        val tvShowDetail = MutableLiveData<TvShowsDetail>()
        remoteRepository.getTvShowDetail(tvId,object  : RemoteRepositoryJava.GetTvShowDetailCallback {
            override fun onResponse(tvShowsResponse: TvShowsDetail) {
                tvShowDetail.postValue(tvShowsResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }

        })
        return tvShowDetail
    }

    override fun getMovieDetail(movieId: String): LiveData<ItemList> {
        val movieDetail = MutableLiveData<ItemList>()
        remoteRepository.getMovieDetail(movieId,object  : RemoteRepositoryJava.GetMovieDetailCallback {
            override fun onResponse(movieResponse: ItemList) {
                movieDetail.postValue(movieResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }

        })
        return movieDetail
    }


    override fun getMovie(): LiveData<List<ItemList>> {
        val movieLists = MutableLiveData<List<ItemList>>()
        remoteRepository.getMovie(object  : RemoteRepositoryJava.GetMovieCallback {
            override fun onResponse(movieResponse: List<ItemList>) {
                movieLists.postValue(movieResponse)
            }

            override fun onErrorResponse() {
                print("error to get movies")
            }
        })
        return movieLists
    }


    override fun getTvShowsList(): LiveData<List<ItemList>> {
        val tvShowsLists = MutableLiveData<List<ItemList>>()

        remoteRepository.getTvShowsList(object : RemoteRepositoryJava.GetTvShowsCallback {
            override fun onResponse(tvShowsResponse: List<ItemList>) {
                tvShowsLists.postValue(tvShowsResponse)
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

        fun getInstance(localeRepository: LocalRepository, remoteRepository: RemoteRepositoryJava): DataRepository? {
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