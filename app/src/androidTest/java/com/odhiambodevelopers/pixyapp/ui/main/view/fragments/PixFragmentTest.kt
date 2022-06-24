package com.odhiambodevelopers.pixyapp.ui.main.view.fragments

import androidx.test.espresso.Espresso
import androidx.test.espresso.ViewAssertion
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.espresso.matcher.ViewMatchers.withEffectiveVisibility
import androidx.test.espresso.matcher.ViewMatchers.withId
import androidx.test.ext.junit.rules.ActivityScenarioRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.odhiambodevelopers.pixyapp.R
import com.odhiambodevelopers.pixyapp.ui.main.view.activities.MainActivity
import org.hamcrest.Matchers.anyOf
import org.hamcrest.Matchers.not
import org.junit.Assert.*
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class PixFragmentTest{

    @Rule
    @JvmField
    var activityScenarioRule = ActivityScenarioRule(MainActivity::class.java)

    @Test
    fun recycler_is_visible(){
        Espresso.onView(withId(R.id.recyclerView))
            .check(ViewAssertions.matches(anyOf(
                withEffectiveVisibility(ViewMatchers.Visibility.GONE),
                withEffectiveVisibility(ViewMatchers.Visibility.INVISIBLE))))
    }

    @Test
    fun search_is_showing(){
        Espresso.onView(withId(R.id.searchImage))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
    }
}