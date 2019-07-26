package com.b.moviecataloguemvvm.model.repository.remote

import com.google.gson.annotations.SerializedName

data class CrewResponse (@SerializedName("crew")
                          val crew: List<CrewList>?)