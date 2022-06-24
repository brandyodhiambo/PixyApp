package com.odhiambodevelopers.pixyapp.ui.main.view.fragments

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import androidx.test.espresso.matcher.ViewMatchers.isDisplayed
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.odhiambodevelopers.pixyapp.R
import org.hamcrest.core.AllOf.allOf
import com.odhiambodevelopers.pixyapp.ui.main.view.activities.MainActivity
import org.junit.Assert.*
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PixDetailsFragmentTest{

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Before
    fun navigateToThisFragment(){
        Thread.sleep(5000)

        val recyclerView = onView(
           allOf(
               withId(R.id.recyclerView)
           )
        )
        recyclerView.perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }

    @Test
    fun toolbar_is_showing(){
        onView(withId(R.id.toolbar))
            .check(ViewAssertions.matches(isDisplayed()))
    }
    @Test
    fun username_is_showing(){
        onView(withId(R.id.textViewUserName))
            .check(ViewAssertions.matches(isDisplayed()))
    }
    @Test
    fun image_is_showing(){
        onView(withId(R.id.imageView))
            .check(ViewAssertions.matches(isDisplayed()))
    }
}