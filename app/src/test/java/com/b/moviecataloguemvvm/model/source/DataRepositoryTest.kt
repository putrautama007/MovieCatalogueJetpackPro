package com.b.moviecataloguemvvm.model.source

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.paging.DataSource
import com.b.moviecataloguemvvm.model.local.LocalRepository
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel
import com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava
import com.b.moviecataloguemvvm.utils.FakeDummy
import com.b.moviecataloguemvvm.utils.InstantAppExecutors
import com.b.moviecataloguemvvm.utils.LiveDataTestUtil
import org.junit.After
import org.junit.Before
import org.junit.Test

import org.junit.Assert.*
import org.junit.Rule
import org.mockito.Mockito.*

class DataRepositoryTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()
    private val localRepository = mock(LocalRepository::class.java)
    private val remoteRepositoryJava = mock(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava::class.java)
    private val appExecutors = mock(InstantAppExecutors::class.java)
    private val dataRepository = FakeDataRepository(localRepository,remoteRepositoryJava,appExecutors)

    private val movieList = FakeDummy.generateRemoteMovies()
    private val movieId = movieList[0].movieId
    private val movieData = movieId?.let { FakeDummy.getRemoteMovieById(it) }

    private val tvShowList = FakeDummy.generateRemoteTvShow()
    private val tvShowId = tvShowList[0].tvShowId
    private val tvShowData = tvShowId?.let { FakeDummy.getRemoteTvShowById(it) }


    @Before
    fun setUp() {
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getMovies() {
        val dataSourceFactory = mock(DataSource.Factory::class.java)

        `when`(localRepository.getMovieAsPaged()).thenReturn(dataSourceFactory as DataSource.Factory<Int, MovieModel>)

        dataRepository.getMovieAsPaged()

        verify(localRepository).getMovieAsPaged()
    }

    @Test
    fun getMovie() {
        val movie = MutableLiveData<MovieModel>()
        movie.value = FakeDummy.getMovieById(movieId)

        `when`(localRepository.getMovieById(movieId)).thenReturn(movie)

        val result = LiveDataTestUtil.getValue(dataRepository.getMovie(movieId))

        verify(localRepository).getMovieById(movieId)
        assertNotNull(result)
    }


    @Test
    fun getTvShows() {
        val dataSourceFactory = mock(DataSource.Factory::class.java)

        `when`(localRepository.getTvShowAsPaged()).thenReturn(dataSourceFactory as DataSource.Factory<Int, TvShowModel>)

        dataRepository.getTvShowAsPaged()

        verify(localRepository).getTvShowAsPaged()
    }

    @Test
    fun getTvShow() {
        val tvShow = MutableLiveData<TvShowModel>()
        tvShow.value = FakeDummy.getTvShowById(tvShowId)

        `when`(localRepository.getTvShowById(tvShowId)).thenReturn(tvShow)

        val result = LiveDataTestUtil.getValue(dataRepository.getTvShow(tvShowId))

        verify(localRepository).getTvShowById(tvShowId)
        assertNotNull(result)
    }

    @Test
    fun getMovieList() {
        doAnswer {
            val callback = it.arguments[0] as com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetMovieListCallback
            callback.onMoviesReceived(movieList)
            null
        }.`when`(remoteRepositoryJava).getMovieList(any(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetMovieListCallback::class.java))

        val result = LiveDataTestUtil.getValue(dataRepository.getMovieList())

        verify(
            remoteRepositoryJava,
            times(1)
        ).getMovieList(any(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetMovieListCallback::class.java))

        assertEquals(movieList.size, result.size)
        assertNotNull(result)
    }

    @Test
    fun getMovieById() {
        doAnswer {
            val callback = it.arguments[1] as com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetMovieByIdCallback
            movieData?.let { it1 -> callback.onMovieReceived(it1) }
            null
        }.`when`(remoteRepositoryJava).getMovieById(
            eq(movieId),
            any(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetMovieByIdCallback::class.java)
        )

        val result = LiveDataTestUtil.getValue(dataRepository.getMovieById(movieId))
        verify(
            remoteRepositoryJava,
            times(1)
        ).getMovieById(
            eq(movieId),
            any(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetMovieByIdCallback::class.java)
        )
        assertEquals(movieData?.movieId, result.movieId)
    }

    @Test
    fun getTvShowList() {
        doAnswer {
            val callback = it.arguments[0] as com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetTvShowListCallback
            callback.onTvShowsReceived(tvShowList)
            null
        }.`when`(remoteRepositoryJava)
            .getTvShowList(any(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetTvShowListCallback::class.java))

        val result = LiveDataTestUtil.getValue(dataRepository.getTvShowList())

        verify(
            remoteRepositoryJava,
            times(1)
        ).getTvShowList(any(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetTvShowListCallback::class.java))

        assertEquals(tvShowList.size, result.size)
    }

    @Test
    fun getTvShowById() {
        doAnswer {
            val callback = it.arguments[1] as com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetTvShowByIdCallback
            tvShowData?.let { it1 -> callback.onTvShowReceived(it1) }
            null
        }.`when`(remoteRepositoryJava).getTvShowById(
            eq(tvShowId),
            any(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetTvShowByIdCallback::class.java)
        )

        val result = LiveDataTestUtil.getValue(dataRepository.getTvShowById(tvShowId))

        verify(
            remoteRepositoryJava,
            times(1)
        ).getTvShowById(eq(tvShowId), any(com.b.moviecataloguemvvm.model.remote.RemoteRepositoryJava.GetTvShowByIdCallback::class.java))

        assertEquals(tvShowData?.tvShowId, result.tvShowId)
    }

}