package Rasitha.Functionality;

import androidx.test.rule.ActivityTestRule;

import com.drex.dashboard.R;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.clearText;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.isDisplayed;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static org.junit.Assert.*;

public class RegisterActivityRazTest {

    @Rule
    public ActivityTestRule<RegisterActivityRaz> mActivityTestRule = new ActivityTestRule<RegisterActivityRaz>(RegisterActivityRaz.class);

    private RegisterActivityRaz mActivity = null;

    String emailraz = "assassin2b2@gmail.com", password1 ="1",password2 ="1234567",
                    username = "Test", f_name="raztest", l_name="sentest", mobile1 = "071778abc",mobile2="071111", mobile3="0717788774";

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testToastsOnClickRegister() throws InterruptedException {
        //assert page load through button loading
        assertNotNull(mActivity.findViewById(R.id.btn_register));

        //test each toast one by one
        onView(withId(R.id.username)).perform(typeText(username));
        closeSoftKeyboard();
        onView(withId(R.id.btn_register)).perform(click());
        onView(withText("All fields are required"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));

        onView(withId(R.id.emailraz)).perform(typeText(emailraz)); closeSoftKeyboard();
        onView(withId(R.id.password)).perform(typeText(password1)); closeSoftKeyboard();
        onView(withId(R.id.f_name)).perform(typeText(f_name)); closeSoftKeyboard();
        onView(withId(R.id.l_name)).perform(typeText(l_name)); closeSoftKeyboard();
        onView(withId(R.id.mobile)).perform(typeText(mobile1)); closeSoftKeyboard();
        closeSoftKeyboard();
        onView(withId(R.id.btn_register)).perform(click());
        onView(withText("password must be at least 6 characters long"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));


        onView(withId(R.id.password)).perform(clearText(),typeText(password2)); closeSoftKeyboard();
        onView(withId(R.id.btn_register)).perform(click());
        closeSoftKeyboard();
        onView(withText("mobile must be a number"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));

        onView(withId(R.id.mobile)).perform(clearText(),typeText(mobile2)); closeSoftKeyboard();
        onView(withId(R.id.btn_register)).perform(click());
        closeSoftKeyboard();
        onView(withText("mobile must be 10 digits"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));


        onView(withId(R.id.mobile)).perform(clearText(),typeText(mobile3)); closeSoftKeyboard();
        onView(withId(R.id.btn_register)).perform(click());
        closeSoftKeyboard();
        onView(withText("username must be longer than 5 characters"))
                .inRoot(new ToastMatcher())
                .check(matches(isDisplayed()));


        //finish activity
        mActivity.finish();

    }
    @After
    public void tearDown() throws Exception {
    }
}