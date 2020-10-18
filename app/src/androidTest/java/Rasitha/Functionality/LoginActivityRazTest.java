package Rasitha.Functionality;



import android.app.Activity;
import android.app.Instrumentation;

import androidx.test.espresso.Espresso;
import androidx.test.rule.ActivityTestRule;

import com.drex.dashboard.R;

import static androidx.test.espresso.Espresso.closeSoftKeyboard;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.*;
import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import Drex.Funcionality.MainActivity;


public class LoginActivityRazTest {

    @Rule
    public ActivityTestRule<LoginActivityRaz> mActivityTestRule = new ActivityTestRule<LoginActivityRaz>(LoginActivityRaz.class);

    String email = "Rasithasen@gmail.com", password ="1234567";

    private LoginActivityRaz mActivity = null;

    Instrumentation.ActivityMonitor monitor = getInstrumentation().addMonitor(MainActivity.class.getName(),null,false);

    @Before
    public void setUp() throws Exception {
        mActivity = mActivityTestRule.getActivity();
    }

    @Test
    public void testLoginOnClick(){
        assertNotNull(mActivity.findViewById(R.id.btn_login));

        //input
        onView(withId(R.id.email)).perform(typeText(email));
        onView(withId(R.id.password)).perform(typeText(password));

        //close keyboard
        closeSoftKeyboard();
        //click
        onView(withId(R.id.btn_login)).perform(click());

        Activity mainActivity = getInstrumentation().waitForMonitorWithTimeout(monitor,10000);
        //assert second activity
        assertNotNull(mainActivity);

        mainActivity.finish();

    }

    @After
    public void tearDown() throws Exception {
    }
}