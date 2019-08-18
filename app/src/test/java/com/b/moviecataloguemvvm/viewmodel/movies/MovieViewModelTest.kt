package com.b.moviecataloguemvvm.viewmodel.movies

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.b.moviecataloguemvvm.model.DataRepository
import com.b.moviecataloguemvvm.model.local.entity.MovieModel
import com.b.moviecataloguemvvm.utils.FakeDummy
import com.b.moviecataloguemvvm.utils.LiveDataTestUtil
import com.b.moviecataloguemvvm.viewmodel.MovieViewModel
import com.b.moviecataloguemvvm.vo.Resource
import org.junit.*

import org.mockito.Mockito
import org.mockito.Mockito.`when`

class MovieViewModelTest {

    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viemModel: MovieViewModel? = null
    private val dataRepository = Mockito.mock(DataRepository::class.java)
    private var data : MovieModel? = null

    @Before
    fun setUp() {
        viemModel = MovieViewModel(dataRepository)
        data = MovieModel(
            1,
            "A Star Is Born",
            "Seasoned musician Jackson Maine discovers — and falls in love with — struggling artist Ally. She has just about given up on her dream to make it big as a singer — until Jack coaxes her into the spotlight. But even as Ally's career takes off, the personal side of their relationship is breaking down, as Jack fights an ongoing battle with his own internal demons.",
            "movie_a_start_is_born",
            "October 3, 2018",
            "75",
            "https://youtu.be/nSbzyEJ8X9E",
            " [\n" +
                    "        {\n" +
                    "          \"crewName\" : \"Bradley Cooper\",\n" +
                    "          \"crewPosition\" : \"Director, Screenplay\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"crewName\" : \"Will Fetters\",\n" +
                    "          \"crewPosition\" : \"Screenplay\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"crewName\" : \"Eric Roth\",\n" +
                    "          \"crewPosition\" : \"Screenplay\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"crewName\" : \"Robert Carson\",\n" +
                    "          \"crewPosition\" : \"Story\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"crewName\" : \"William A. Wellman\",\n" +
                    "          \"crewPosition\" : \"Story\"\n" +
                    "        }\n" +
                    "      ]"
        )
    }

    @After
    fun tearDown() {
    }


    @Test
    fun getMovies() {
        val moviesMutable = MutableLiveData<List<MovieModel>>()
        moviesMutable.value = FakeDummy.generateMovies()
       `when`(dataRepository.getMovieList()).thenReturn(moviesMutable)
        val observer = Mockito.mock(Observer::class.java)
        viemModel?.movies?.observeForever(observer as Observer<List<MovieModel>>)
        Mockito.verify(dataRepository).getMovieList()
    }

    @Test
    fun movieDetail() {
        val moviesMutable = MutableLiveData<MovieModel>()
        moviesMutable.value = data?.movieId?.let { FakeDummy.getMovieById(it) }
        Mockito.`when`(data?.movieId?.let { dataRepository.getMovieById(it) }).thenReturn(moviesMutable)
        val observer = Mockito.mock(Observer::class.java)
        data?.movieId?.let { viemModel?.movieDetail(it)?.observeForever(observer as Observer<MovieModel>) }
        data?.movieId?.let { Mockito.verify(dataRepository).getMovieById(it) }
        Assert.assertEquals(data?.movieId, data?.movieId?.let { viemModel?.movieDetail(it)?.value?.movieId })
        Assert.assertEquals(data?.movieTitle, data?.movieId?.let { viemModel?.movieDetail(it)?.value?.movieTitle })
        Assert.assertEquals(data?.movieDescription,
            data?.movieId?.let { viemModel?.movieDetail(it)?.value?.movieDescription })
        Assert.assertEquals(data?.moviePoster, data?.movieId?.let { viemModel?.movieDetail(it)?.value?.moviePoster })
        Assert.assertEquals(data?.movieRelease, data?.movieId?.let { viemModel?.movieDetail(it)?.value?.movieRelease })
    }

    @Test
    fun getMovie(){
        val movie = MutableLiveData<Resource<MovieModel>>()
        movie.value = Resource.success(this.data?.movieId?.let { FakeDummy.getMovieById(it) })

       `when`(this.data?.movieId?.let { dataRepository.getMovie(it) }).thenReturn(movie)

        val observer = Mockito.mock(Observer::class.java)

        viemModel?.getMovie?.observeForever(observer as Observer<Resource<MovieModel>>)

        val result = LiveDataTestUtil.getValue(dataRepository.getMovie(this.data?.movieId!!))
        Assert.assertNotNull(result)
    }

}