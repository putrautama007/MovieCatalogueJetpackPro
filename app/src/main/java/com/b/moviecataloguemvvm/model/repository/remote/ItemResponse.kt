package com.b.moviecataloguemvvm.model.repository.remote

import com.google.gson.annotations.SerializedName

data class ItemResponse(
    @SerializedName("results")
    val results: List<ItemList>? )