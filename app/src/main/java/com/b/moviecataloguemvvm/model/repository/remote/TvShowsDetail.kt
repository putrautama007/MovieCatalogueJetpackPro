package com.b.moviecataloguemvvm.model.repository.remote

import com.google.gson.annotations.SerializedName

data class TvShowsDetail(
    @SerializedName("backdrop_path")
    val backdrop_path: String?,
    @SerializedName("name")
    val name: String?,
    @SerializedName("id")
    val id: Int?,
    @SerializedName("first_air_date")
    val first_air_date: String?,
    @SerializedName("vote_average")
    val vote_average: Double?,
    @SerializedName("overview")
    val overview: String?,
    @SerializedName("original_language")
    val original_language: String?,
    @SerializedName("poster_path")
    val posterPath: String?
)