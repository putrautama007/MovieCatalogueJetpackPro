package com.b.moviecataloguemvvm.model.remote.response

data class TvShowModelResponse(
    val tvShowId: Int=0,
    val tvShowTitle: String?="",
    val tvShowDescription: String?="",
    val tvShowPoster : String?="",
    val tvShowRelease: String?="",
    val tvShowRating : String?="",
    val tvShowTrailer : String?="",
    val featuredCrew: String?=""
)