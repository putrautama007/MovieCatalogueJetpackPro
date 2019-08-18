package com.b.moviecataloguemvvm.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class MovieModel (
    @PrimaryKey
    val movieId: Int? = 0,
    val movieTitle: String? = "",
    val movieDescription: String? = "",
    val moviePoster : String?= "",
    val movieRelease: String?= "",
    val movieRating : String?= "",
    val movieTrailer : String?= "",
    val featuredCrew: String?= "",
    var favorite: Boolean = false
)