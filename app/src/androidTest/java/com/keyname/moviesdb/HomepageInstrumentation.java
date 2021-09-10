package com.keyname.moviesdb;

import static androidx.test.espresso.Espresso.onData;
import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.assertion.ViewAssertions.matches;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static androidx.test.espresso.matcher.ViewMatchers.withText;
import static androidx.test.espresso.matcher.RootMatchers.withDecorView;
import static org.hamcrest.CoreMatchers.anything;
import static org.hamcrest.Matchers.not;

import android.view.View;

import androidx.test.core.app.ActivityScenario;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
@RunWith(AndroidJUnit4.class)
public class HomepageInstrumentation {
    @Rule
    public ActivityScenarioRule<Homepage> activityTestRule=new ActivityScenarioRule<>(Homepage.class);
    private View activityDecorView;
    @Before
    public void setUp(){
        activityTestRule.getScenario().onActivity(new ActivityScenario.ActivityAction<Homepage>() {
    @Override
    public void perform(Homepage activity) {
        activityDecorView=activity.getWindow().getDecorView();
    }
});
    }
    @Test
    public void movieListItemDisplaysToastOnClick(){
        String movie="toy story";
        onData(anything())
                .inAdapterView(withId(R.id.homepageListView))
                .atPosition(0)
                .perform(click());
        onView(withText(movie)).inRoot(withDecorView(not(activityDecorView))).check(matches(withText(movie)));

    }


}
