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

class FavoriteTvShowFragmentTest{
    @Rule
    @JvmField
    val activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private val favoriteTvShowFragment = FavoriteTvShowFragment()

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.getEspressoIdlingResource())
        activityRule.activity.setFragment(favoriteTvShowFragment)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.getEspressoIdlingResource())
    }

    @Test
    fun getData() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_favorite_tv_show))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_favorite_tv_show)).check(RecyclerViewItemCountAssertion(2))
    }
}