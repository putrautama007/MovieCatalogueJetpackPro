package com.b.moviecataloguemvvm.viewmodel.tvshows

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.b.moviecataloguemvvm.FakeData
import com.b.moviecataloguemvvm.model.repository.DataRepository
import com.b.moviecataloguemvvm.model.repository.remote.CrewList
import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.model.repository.remote.TvShowsDetail
import com.b.moviecataloguemvvm.viewmodel.TvShowViewModel
import junit.framework.Assert
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test

import org.junit.Rule
import org.mockito.Mockito

class TvShowViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viemModel: TvShowViewModel? = null
    private var data = Mockito.mock(DataRepository::class.java)
    private lateinit var tvshow: ItemList


    @Before
    fun setUp() {
        viemModel = TvShowViewModel(data)
        tvshow =  ItemList(
            "/b71BaRjp9TwxUZodLGgSRIlkfL8.jpg",
            "The dramatisation of one of the most notorious killing sprees in British history.",
            "",
            11634,
            "",
            "en",
            "",
            "/7AKhSfJHnVi0zXQS4eJirHDs22p.jpg",
            4.5,
            "See No Evil: The Moors Murders"
        )

    }

    @After
    fun tearDown() {
    }
    @Test
    fun getTvShow() {
        val tvShows = MutableLiveData<List<ItemList>>()
        tvShows.value = FakeData.getDummyRemoteTvShows()
        Mockito.`when`(data.getTvShowsList()).thenReturn(tvShows)
        val observer = Mockito.mock(Observer::class.java)
        viemModel?.tvShow?.observeForever(observer as Observer<List<ItemList>>)
        Mockito.verify(data).getTvShowsList()
    }

    @Test
    fun getTvShowDetail() {
        val tvShow = MutableLiveData<TvShowsDetail>()
        tvShow.value = FakeData.getTvShowsDetail()
        Mockito.`when`(data.getTvShowsDetail(tvShow.value!!.id.toString())).thenReturn(tvShow)
        val observer = Mockito.mock(Observer::class.java)
        viemModel?.getTvShowDetail(tvShow.value!!.id.toString())?.observeForever(observer as Observer<TvShowsDetail>)
        Mockito.verify(data).getTvShowsDetail(tvShow.value!!.id.toString())
        assertEquals(tvShow.value!!.id, viemModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.id)
        assertEquals(tvShow.value!!.name, viemModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.name)
        assertEquals(tvShow.value!!.overview, viemModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.overview)
        assertEquals(tvShow.value!!.posterPath, viemModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.posterPath)
        assertEquals(tvShow.value!!.first_air_date, viemModel?.getTvShowDetail(tvShow.value!!.id.toString())?.value?.first_air_date)
    }

    @Test
    fun getTvShowCrew() {
        val tvShows = MutableLiveData<List<CrewList>>()
        tvShows.value = FakeData.getTvShowCrew()
        Mockito.`when`(data.getTvShowsCrew(tvshow.id.toString())).thenReturn(tvShows)
        val observer = Mockito.mock(Observer::class.java)
        viemModel?.getTvShowCrew(tvshow.id.toString())?.observeForever(observer as Observer<List<CrewList>>)
        Mockito.verify(data).getTvShowsCrew(tvshow.id.toString())
    }
}