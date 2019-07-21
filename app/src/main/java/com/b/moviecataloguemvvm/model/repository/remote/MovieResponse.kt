package com.b.moviecataloguemvvm.model.repository.remote

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results")
    val results: List<MovieList>? )