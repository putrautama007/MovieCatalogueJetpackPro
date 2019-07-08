package com.b.moviecataloguemvvm.view

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId

import androidx.test.rule.ActivityTestRule
import com.b.moviecataloguemvvm.R
import org.junit.Rule
import org.junit.Test

class HomeActivityTest{
    @Rule
    @JvmField
    var activityRule = ActivityTestRule(HomeActivity::class.java)

    @Test
    fun testAppBehaviour(){
        Thread.sleep(3000)
        onView(withId(R.id.nav_view))
            .check(matches(isDisplayed()))
        Thread.sleep(3000)
        onView(withId(R.id.navigation_movie)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.navigation_movie)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        Thread.sleep(1000)
        pressBack()
        Thread.sleep(4000)

        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))
        Thread.sleep(1000)
        pressBack()
        Thread.sleep(4000)

        onView(withId(R.id.navigation_tv_show)).check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.navigation_tv_show)).perform(click())
        Thread.sleep(3000)
        onView(withId(R.id.rv_tv_show))
            .check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(1, click()))
        Thread.sleep(1000)
        pressBack()
        Thread.sleep(4000)

        onView(withId(R.id.rv_tv_show))
            .check(matches(isDisplayed()))
        Thread.sleep(1000)
        onView(withId(R.id.rv_tv_show)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(3, click()))
        Thread.sleep(1000)
        pressBack()
        Thread.sleep(4000)
    }
}