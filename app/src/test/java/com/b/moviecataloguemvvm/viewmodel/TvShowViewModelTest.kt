package com.b.moviecataloguemvvm.viewmodel

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Observer
import com.b.moviecataloguemvvm.model.DataRepository
import com.b.moviecataloguemvvm.model.local.entity.TvShowModel
import com.b.moviecataloguemvvm.utils.FakeDummy
import com.b.moviecataloguemvvm.utils.LiveDataTestUtil
import com.b.moviecataloguemvvm.vo.Resource
import org.junit.*

import org.junit.Assert.*
import org.mockito.Mockito
import org.mockito.Mockito.`when`

class TvShowViewModelTest {
    @Rule
    @JvmField
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private var viemModel: TvShowViewModel? = null
    private val dataRepository = Mockito.mock(DataRepository::class.java)
    private var data : TvShowModel? = null

    @Before
    fun setUp() {
        viemModel = TvShowViewModel(dataRepository)
        data = TvShowModel(
            1,
            "Arrow",
            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
            "tvshow_arrow",
            "October 10, 2012",
            "58",
            "https://youtu.be/hTv13EjlLNg",
            " [\n" +
                    "        {\n" +
                    "          \"crewName\": \"Greg Berlant\",\n" +
                    "          \"crewPosition\": \"Creator\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"crewName\": \"Marc Guggenheim\",\n" +
                    "          \"crewPosition\": \"Creator\"\n" +
                    "        },\n" +
                    "        {\n" +
                    "          \"crewName\": \"Andrew Kreisberg\",\n" +
                    "          \"crewPosition\": \"Creator\"\n" +
                    "        }\n" +
                    "      ]"
        )
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getTvShows() {
        val tvShowsMutable = MutableLiveData<List<TvShowModel>>()
        tvShowsMutable.value = FakeDummy.generateTvShow()
       `when`(dataRepository.getTvShowList()).thenReturn(tvShowsMutable)
        val observer = Mockito.mock(Observer::class.java)
        viemModel?.tvShow?.observeForever(observer as Observer<List<TvShowModel>>)
        Mockito.verify(dataRepository).getTvShowList()
    }

    @Test
    fun tvShowDetail() {
        val tvShowMutable = MutableLiveData<TvShowModel>()
        tvShowMutable.value = data?.tvShowId?.let { FakeDummy.getTvShowById(it) }
        Mockito.`when`(data?.tvShowId?.let { dataRepository.getTvShowById(it) }).thenReturn(tvShowMutable)
        val observer = Mockito.mock(Observer::class.java)
        data?.tvShowId?.let { viemModel?.tvShowDetail(it)?.observeForever(observer as Observer<TvShowModel>) }
        data?.tvShowId?.let { Mockito.verify(dataRepository).getTvShowById(it) }
        assertEquals(data?.tvShowId, data?.tvShowId?.let { viemModel?.tvShowDetail(it)?.value?.tvShowId })
        assertEquals(data?.tvShowTitle, data?.tvShowId?.let { viemModel?.tvShowDetail(it)?.value?.tvShowTitle })
        assertEquals(data?.tvShowDescription,
            data?.tvShowId?.let { viemModel?.tvShowDetail(it)?.value?.tvShowDescription })
        assertEquals(data?.tvShowPoster, data?.tvShowId?.let { viemModel?.tvShowDetail(it)?.value?.tvShowPoster })
        assertEquals(data?.tvShowRelease, data?.tvShowId?.let { viemModel?.tvShowDetail(it)?.value?.tvShowRelease })
    }

    @Test
    fun getTvShow(){
        val tvShow = MutableLiveData<Resource<TvShowModel>>()
        tvShow.value = Resource.success(this.data?.tvShowId?.let { FakeDummy.getTvShowById(it) })

        `when`(this.data?.tvShowId?.let { dataRepository.getTvShow(it) }).thenReturn(tvShow)

        val observer = Mockito.mock(Observer::class.java)

        viemModel?.getTvShow?.observeForever(observer as Observer<Resource<TvShowModel>>)

        val result = LiveDataTestUtil.getValue(dataRepository.getTvShow(this.data?.tvShowId!!))
        assertNotNull(result)
    }
}