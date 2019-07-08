package com.b.moviecataloguemvvm.model

data class TvShowModel(
    val tvShowId: Int?,
    val tvShowTitle: String?,
    val tvShowDescription: String?,
    val tvShowPoster : Int?,
    val tvShowRelease: String?,
    val tvShowRating : String?,
    val tvShowTrailer : String?,
    val featuredCrew: List<FeaturedCrew>
)