package com.b.moviecataloguemvvm.view

import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.rule.ActivityTestRule
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.testing.SingleFragmentActivity
import com.b.moviecataloguemvvm.utils.EspressoIdlingResource
import com.b.moviecataloguemvvm.utils.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class FavoriteMovieFragmentTest{
    @Rule
    @JvmField
    val activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private val favoriteMovieFragment = FavoriteMovieFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
        activityRule.activity.setFragment(favoriteMovieFragment)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun getData() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_favorite_movie))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_favorite_movie)).check(
            RecyclerViewItemCountAssertion(2)
        )
    }
}