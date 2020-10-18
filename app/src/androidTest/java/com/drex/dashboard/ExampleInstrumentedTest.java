package com.drex.dashboard;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import Drex.Funcionality.MainActivity;
import Drex.Funcionality.Std_profile_drex;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.closeSoftKeyboard;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;

@RunWith(AndroidJUnit4.class)
@LargeTest
public class ExampleInstrumentedTest {

    private String firstname;
    private String lastname;
    private String mobile;

    @Rule
    public ActivityScenarioRule<Std_profile_drex> activityRule = new ActivityScenarioRule<>(Std_profile_drex.class);

    @Before
    public void initValidString() {
        firstname = "akila";
        lastname = "ratnyake";
        mobile = "0987654321";
    }

    @Test
    public void changeUser_Details() {
        // Type text and then press the button.
        onView(withId(R.id.upname1)).perform(typeText(firstname));
        onView(withId(R.id.upemail1)).perform(typeText(lastname));
        onView(withId(R.id.upaddress1)).perform(typeText(mobile), closeSoftKeyboard());
        onView(withId(R.id.upbuttonup1)).perform(click());
        // Check that the text was changed.
//        onView(withId(R.id.textToBeChanged))
//                .check(matches(withText(stringToBetyped)));
    }

    @Rule
    public ActivityScenarioRule<MainActivity> activityRule2 = new ActivityScenarioRule<>(MainActivity.class);

    @Test
    public void checkActivity() {
        // Type text and then press the button.
        onView(withId(R.id.upname1)).perform(typeText(firstname));
        onView(withId(R.id.upemail1)).perform(typeText(lastname));
        onView(withId(R.id.upaddress1)).perform(typeText(mobile), closeSoftKeyboard());
        onView(withId(R.id.upbuttonup1)).perform(click());
    }
}