package com.b.moviecataloguemvvm.model.remote.response


data class MovieModelResponse (
    val movieId: Int=0,
    val movieTitle: String?="",
    val movieDescription: String?="",
    val moviePoster : String?="",
    val movieRelease: String?="",
    val movieRating : String?="",
    val movieTrailer : String?="",
    val featuredCrew: String?=""
)