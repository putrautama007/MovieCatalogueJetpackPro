package com.b.moviecataloguemvvm.model.repository.remote

import com.google.gson.annotations.SerializedName

data class CrewList (
    @SerializedName("job")
    val job:String?,
    @SerializedName("name")
    val name:String?
)