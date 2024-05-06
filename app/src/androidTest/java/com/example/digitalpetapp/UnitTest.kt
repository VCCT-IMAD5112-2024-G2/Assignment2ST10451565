package com.example.digitalpetapp

import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.action.ViewActions.click
import androidx.test.espresso.assertion.ViewAssertions.matches
import androidx.test.espresso.matcher.ViewMatchers.*
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.LargeTest
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class UnitTest {

    @Before
    fun setUp() {
        ActivityScenario.launch(SecondPage::class.java)
    }

    @Test
    fun happyCounterTextView_isDisplayed() {
        onView(withId(R.id.happyCounterTextView)).check(matches(isDisplayed()))
    }

    @Test
    fun cleanCounterTextView_isDisplayed() {
        onView(withId(R.id.cleanCounterTextView)).check(matches(isDisplayed()))
    }

    @Test
    fun hungerCounterTextView_isDisplayed() {
        onView(withId(R.id.hungerCounterTextView)).check(matches(isDisplayed()))
    }

    @Test
    fun playBtn_click() {
        onView(withId(R.id.playBtn)).perform(click())
        onView(withId(R.id.happyCounterTextView)).check(matches(withText("Happy: 55 / 50")))
    }

    @Test
    fun cleanBtn_click() {
        onView(withId(R.id.cleanBtn)).perform(click())
        onView(withId(R.id.cleanCounterTextView)).check(matches(withText("Clean: 55 / 50")))
    }

    @Test
    fun feedBtn_click() {
        onView(withId(R.id.feedbtn)).perform(click())
        onView(withId(R.id.hungerCounterTextView)).check(matches(withText("Hunger: 55 / 50")))
    }
}