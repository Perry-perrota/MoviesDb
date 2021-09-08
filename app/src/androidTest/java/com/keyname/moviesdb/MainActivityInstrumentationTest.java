package com.keyname.moviesdb;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.filters.LargeTest;
import androidx.test.runner.AndroidJUnit4;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
    @RunWith(AndroidJUnit4.class)
    @LargeTest
    public class MainActivityInstrumentationTest {
        @Rule
        public ActivityScenarioRule<MainActivity> activityRule=
                new ActivityScenarioRule<MainActivity>(MainActivity.class);
        @Test
        public void validateEditText(){
            onView(withId(R.id.splashPageEditText)).perform(typeText("Nairobi")
            ).check(matches(withText("Nairobi")));
        }
        @Test
        public void locationIsSentToHomepage(){
            String location = "Nairobi";
            onView(withId(R.id.splashPageEditText)).perform(typeText(location)).perform(closeSoftKeyboard());
            try {                             // the sleep method requires to be checked and handled so we use try block
                Thread.sleep(250);
            } catch (InterruptedException e){
                System.out.println("got interrupted!");
            }
            onView(withId(R.id.findMovieButton)).perform(click());
            onView(withId(R.id.homepageTextView)).check(matches
                    (withText("matching close to " + location)));
        }
    }
