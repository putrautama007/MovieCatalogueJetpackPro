package com.b.moviecataloguemvvm.utils

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.NoMatchingViewException
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.matcher.ViewMatchers
import org.hamcrest.core.Is
import org.junit.Assert

class RecyclerViewItemCountAssertion(private val recyclerViewExpectation: Int) : ViewAssertion{
    override fun check(view: View?, noViewFoundException: NoMatchingViewException?) {
        if (noViewFoundException != null) {
            throw noViewFoundException
        }

        val recyclerViewExpectation = view as RecyclerView
        val adapter = recyclerViewExpectation.adapter
        Assert.assertNotNull(adapter)
        ViewMatchers.assertThat(adapter!!.itemCount, Is.`is`(this.recyclerViewExpectation))
    }
}