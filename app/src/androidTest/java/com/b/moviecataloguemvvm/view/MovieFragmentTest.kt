package com.b.moviecataloguemvvm.view

import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.rule.ActivityTestRule
import com.b.moviecataloguemvvm.R
import com.b.moviecataloguemvvm.testing.SingleFragmentActivity
import com.b.moviecataloguemvvm.utils.RecyclerViewItemCountAssertion
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test

class MovieFragmentTest {

    @Rule
    @JvmField
    val activityRule: ActivityTestRule<SingleFragmentActivity> = ActivityTestRule(SingleFragmentActivity::class.java)
    private val moviesFragment = MovieFragment()

    @Before
    fun setUp() {
        activityRule.activity.setFragment(moviesFragment)
    }

    @After
    fun tearDown() {
    }

    @Test
    fun getData() {
        onView(withId(R.id.rv_movie))
            .check(matches(isDisplayed()))
        Thread.sleep(3000)
        onView(withId(R.id.rv_movie)).check(RecyclerViewItemCountAssertion(19))


    }
}