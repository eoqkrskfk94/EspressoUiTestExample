package com.mj.espressouitestexample

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.Espresso.pressBack
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner

import org.junit.Test
import org.junit.runner.RunWith


@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {


    @Test
    fun test_navSecondaryActivity() {
        //launch activity with espresso
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // test next button click
        onView(withId(R.id.button_next_activity)).perform(click())

        // test if secondary activity is in view
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

    }

    @Test
    fun test_backPress_toMainActivity() {
        //launch activity with espresso
        val activityScenario = ActivityScenario.launch(MainActivity::class.java)

        // test next button click
        onView(withId(R.id.button_next_activity)).perform(click())

        // test if secondary activity is in view
        onView(withId(R.id.secondary)).check(matches(isDisplayed()))

        // test back button click
        onView(withId(R.id.button_back)).perform(click())

        // pressBack() // method 2

        // test if secondary activity is in view
        onView(withId(R.id.main)).check(matches(isDisplayed()))
    }


//    @Test
//    fun test_isActivityInView() {
//        //launch activity with espresso
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//
//        //test if an activity is in view
//        onView(withId(R.id.main)).check(matches(isDisplayed()))
//    }
//
//    @Test
//    fun test_visibility_title_nextButton() {
//        //launch activity with espresso
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//
//        //test if text is in view
//        onView(withId(R.id.activity_main_title))
//            .check(matches(isDisplayed()))
//
//        //test if button is in view
//        onView(withId(R.id.button_next_activity))
//            .check(matches(isDisplayed()))
//
//        //test if button is visible
//        onView(withId(R.id.button_next_activity))
//            .check(matches(withEffectiveVisibility(Visibility.VISIBLE)))
//    }
//
//    @Test
//    fun test_isTitleTextDisplayed() {
//        //launch activity with espresso
//        val activityScenario = ActivityScenario.launch(MainActivity::class.java)
//
//        //test if text is a specific text
//        onView(withId(R.id.activity_main_title))
//            .check(matches(withText(R.string.text_mainactivity)))
//    }
}