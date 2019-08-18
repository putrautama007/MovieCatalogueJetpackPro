package com.b.moviecataloguemvvm.model.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TvShowModel(
    @PrimaryKey
    val tvShowId: Int?=0,
    val tvShowTitle: String?="",
    val tvShowDescription: String?="",
    val tvShowPoster : String?="",
    val tvShowRelease: String?="",
    val tvShowRating : String?="",
    val tvShowTrailer : String?="",
    val featuredCrew: String?="",
    var favorite: Boolean = false
)