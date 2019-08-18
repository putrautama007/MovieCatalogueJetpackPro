package com.b.moviecataloguemvvm.viewmodel.tvshows

//class TvShowViewModelTest{
//    private var viemModel: TvShowViewModel? = null
//    private var data : TvShowModelResponse? = null
//
//    @Before
//    fun setUp() {
//        viemModel = TvShowViewModel()
//        data = TvShowModelResponse(
//            1,
//            "Arrow",
//            "Spoiled billionaire playboy Oliver Queen is missing and presumed dead when his yacht is lost at sea. He returns five years later a changed man, determined to clean up the city as a hooded vigilante armed with a bow.",
//            R.drawable.tvshow_arrow,
//            "October 10, 2012",
//            "58",
//            "https://youtu.be/hTv13EjlLNg",
//            listOf(
//                FeaturedCrew(
//                    "Greg Berlanti",
//                    "Creator"
//                ),
//                FeaturedCrew(
//                    "Marc Guggenheim",
//                    "Creator"
//                ),
//                FeaturedCrew(
//                    "Andrew Kreisberg",
//                    "Creator"
//                )
//            )
//        )
//    }
//
//    @After
//    fun tearDown() {
//    }
//
//    @Test
//    fun getResult() {
//        assertEquals(20, viemModel?.tvShow?.size)
//        assertEquals(data?.tvShowId, viemModel?.tvShowDetail(1)?.tvShowId)
//        assertEquals(data?.tvShowTitle, viemModel?.tvShowDetail(1)?.tvShowTitle)
//        assertEquals(data?.tvShowDescription, viemModel?.tvShowDetail(1)?.tvShowDescription)
//        assertEquals(data?.tvShowPoster, viemModel?.tvShowDetail(1)?.tvShowPoster)
//        assertEquals(data?.tvShowRating, viemModel?.tvShowDetail(1)?.tvShowRating)
//        assertEquals(data?.tvShowRelease, viemModel?.tvShowDetail(1)?.tvShowRelease)
//        assertEquals(data?.featuredCrew, viemModel?.tvShowDetail(1)?.featuredCrew)
//    }
//}