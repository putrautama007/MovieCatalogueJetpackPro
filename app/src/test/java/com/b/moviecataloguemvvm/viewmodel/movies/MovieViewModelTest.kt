package com.b.moviecataloguemvvm.viewmodel.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.b.moviecataloguemvvm.FakeData
import com.b.moviecataloguemvvm.model.repository.DataRepository
import com.b.moviecataloguemvvm.model.repository.remote.CrewList
import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import org.junit.*
import org.junit.Assert.assertEquals

import org.mockito.Mockito

class MovieViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viemModel: MovieViewModel? = null
    private val data  = Mockito.mock(DataRepository::class.java)
    private lateinit var itemList: ItemList

    @Before
    fun setUp() {
        viemModel = MovieViewModel(data)
        itemList = ItemList(
            "/dzBtMocZuJbjLOXvrl4zGYigDzh.jpg",
            "Simba idolises his father, King Mufasa, and takes to heart his own royal destiny. But not everyone in the kingdom celebrates the new cub's arrival. Scar, Mufasa's brother—and former heir to the throne—has plans of his own. The battle for Pride Rock is ravaged with betrayal, tragedy and drama, ultimately resulting in Simba's exile. With help from a curious pair of newfound friends, Simba will have to figure out how to grow up and take back what is rightfully his.",
            "2019-07-12",
            420818,
            "The Lion King",
            "en",
            "The Lion King",
            "/1TUg5pO1VZ4B0Q1amk3OlXvlpXV.jpg",
            7.2,
            ""
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getMovie() {
        val movies = MutableLiveData<List<ItemList>>()
        movies.value = FakeData.getDummyRemoteMovie()
        Mockito.`when`(data.getMovie()).thenReturn(movies)
        val observer = Mockito.mock(Observer::class.java)
        viemModel?.movie?.observeForever(observer as Observer<List<ItemList>>)
        Mockito.verify(data).getMovie()
    }

    @Test
    fun getMovieDetail() {
        val movies = MutableLiveData<ItemList>()
        movies.value = FakeData.getDummyRemoteMovie()[0]
        Mockito.`when`(data.getMovieDetail(movies.value!!.id.toString())).thenReturn(movies)
        val observer = Mockito.mock(Observer::class.java)
        viemModel?.getMovieDetail(movies.value!!.id.toString())?.observeForever(observer as Observer<ItemList>)
        Mockito.verify(data).getMovieDetail(movies.value!!.id.toString())
        assertEquals( movies.value!!.id, viemModel?.getMovieDetail(movies.value!!.id.toString())?.value?.id)
        assertEquals(movies.value!!.title, viemModel?.getMovieDetail(movies.value!!.id.toString())?.value?.title)
        assertEquals(movies.value!!.overview, viemModel?.getMovieDetail(movies.value!!.id.toString())?.value?.overview)
        assertEquals(movies.value!!.posterPath, viemModel?.getMovieDetail(movies.value!!.id.toString())?.value?.posterPath)
        assertEquals(movies.value!!.release_date, viemModel?.getMovieDetail(movies.value!!.id.toString())?.value?.release_date)
    }

    @Test
    fun getMovieCrew() {
        val crew = MutableLiveData<List<CrewList>>()
        crew.value = FakeData.getMovieCrew()
        Mockito.`when`(data.getMovieCrew(itemList.id.toString())).thenReturn(crew)
        val observer = Mockito.mock(Observer::class.java)
        viemModel?.getMovieCrew(itemList.id.toString())?.observeForever(observer as Observer<List<CrewList>>)
        Mockito.verify(data).getMovieCrew(itemList.id.toString())
    }
}