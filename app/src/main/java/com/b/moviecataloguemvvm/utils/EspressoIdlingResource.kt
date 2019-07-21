package com.b.moviecataloguemvvm.utils

import androidx.test.espresso.IdlingResource
import androidx.test.espresso.idling.CountingIdlingResource

object EspressoIdlingResource {
    val RESOURCE = "GLOBAL"
    val espressoTestIdlingResource =CountingIdlingResource(RESOURCE)

    val espressoIdlingResource : IdlingResource get() = espressoTestIdlingResource

    fun increment(){
        espressoTestIdlingResource.increment()
    }
    fun decrement(){
        espressoTestIdlingResource.decrement()
    }
}