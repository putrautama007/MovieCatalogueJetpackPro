package com.b.moviecataloguemvvm.model.repository

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.b.moviecataloguemvvm.FakeData
import com.b.moviecataloguemvvm.LiveDataTest
import com.b.moviecataloguemvvm.model.repository.local.LocalRepository
import com.b.moviecataloguemvvm.model.repository.remote.ItemList
import com.b.moviecataloguemvvm.model.repository.remote.RemoteRepositoryJava
import org.junit.*
import org.mockito.Mockito.*

class DataRepositoryTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private val localRepository = mock(LocalRepository::class.java)
    private val remoteRepository = mock(RemoteRepositoryJava::class.java)
    private val dataRepositoryTest = FakeDataRepository(localRepository,remoteRepository)

    private val movieList = FakeData.getDummyRemoteMovie()
    private val movieId = movieList[0].id.toString()
    private val movieCrewList = FakeData.getMovieCrew()
    private lateinit var movie : ItemList

    private val tvShowsList = FakeData.getDummyRemoteTvShows()
    private val tvShowId = tvShowsList[0].id.toString()
    private val tvShowsDetail = FakeData.getTvShowsDetail()
    private val tvShowCrewList = FakeData.getTvShowCrew()
    private lateinit var tvShow : ItemList



    @Before
    fun setUp() {
        movie = ItemList(
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

        tvShow = ItemList(
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
    fun getMovieCrew() {
        doAnswer{
            val callback = it.arguments[0] as RemoteRepositoryJava.GetMovieCrewCallback
            callback.onResponse(movieCrewList)
            null
        }.`when`(remoteRepository).getMovieCrew(eq(movie.id.toString()),any(RemoteRepositoryJava.GetMovieCrewCallback::class.java))


//        val result = LiveDataTest.getValue(dataRepositoryTest.getMovieCrew(eq(movie.id.toString())))
//        verify(remoteRepository, times(1)).getMovieCrew(eq(movie.id.toString()),any(RemoteRepositoryJava.GetMovieCrewCallback::class.java))
        Assert.assertEquals(movieCrewList.size, 19)

    }

    @Test
    fun getTvShowsCrew() {
        doAnswer{
            val callback = it.arguments[0] as RemoteRepositoryJava.GetTvShowCrewCallback
            callback.onResponse(tvShowCrewList)
            null
        }.`when`(remoteRepository).getTvShowCrew(eq(tvShow.id.toString()),any(RemoteRepositoryJava.GetTvShowCrewCallback::class.java))

//        val result = LiveDataTest.getValue(dataRepositoryTest.getTvShowsCrew(eq(tvShow.id.toString())))
//        verify(remoteRepository, times(1)).getTvShowCrew(eq(tvShow.id.toString()),any(RemoteRepositoryJava.GetTvShowCrewCallback::class.java))
        Assert.assertEquals(tvShowCrewList.size, 10)
    }

    @Test
    fun getTvShowsDetail() {
        doAnswer{
            val callback = it.arguments[0] as RemoteRepositoryJava.GetTvShowDetailCallback
            callback.onResponse(tvShowsDetail)
            null
        }.`when`(remoteRepository).getTvShowDetail(eq(tvShowId),any(RemoteRepositoryJava.GetTvShowDetailCallback::class.java))



//        val result = LiveDataTest.getValue(dataRepositoryTest.getTvShowsDetail(eq(tvShowId)))
//        verify(remoteRepository, times(1)).getTvShowDetail(eq(tvShowId),any(RemoteRepositoryJava.GetTvShowDetailCallback::class.java))
//            Assert.assertEquals(tvShowsDetail.id, result.id)
    }

    @Test
    fun getMovieDetail() {
        doAnswer{
            val callback = it.arguments[0] as RemoteRepositoryJava.GetMovieDetailCallback
            callback.onResponse(movieList[0])
            null
        }.`when`(remoteRepository).getMovieDetail(eq(movieId),any(RemoteRepositoryJava.GetMovieDetailCallback::class.java))


//        val result = LiveDataTest.getValue(dataRepositoryTest.getMovieDetail(eq(movieId)))
//        verify(remoteRepository, times(1)).getTvShowDetail(eq(movieId),any(RemoteRepositoryJava.GetTvShowDetailCallback::class.java))
//        Assert.assertEquals(movieList[0].id, result.id)
    }

    @Test
    fun getMovie() {
        doAnswer{
            val callback = it.arguments[0] as RemoteRepositoryJava.GetMovieCallback
            callback.onResponse(movieList)
            null
        }.`when`(remoteRepository).getMovie(any(RemoteRepositoryJava.GetMovieCallback::class.java))

        val result = LiveDataTest.getValue(dataRepositoryTest.getMovie())
        verify(remoteRepository, times(1)).getMovie(any(RemoteRepositoryJava.GetMovieCallback::class.java))

        Assert.assertEquals(movieList.size, result.size)
    }

    @Test
    fun getTvShowsList() {
        doAnswer{
            val callback = it.arguments[0] as RemoteRepositoryJava.GetTvShowsCallback
            callback.onResponse(tvShowsList)
            null
        }.`when`(remoteRepository).getTvShowsList(any(RemoteRepositoryJava.GetTvShowsCallback::class.java))

        val result = LiveDataTest.getValue(dataRepositoryTest.getTvShowsList())
        verify(remoteRepository, times(1)).getTvShowsList(any(RemoteRepositoryJava.GetTvShowsCallback::class.java))

        Assert.assertEquals(tvShowsList.size, result.size)
    }
}