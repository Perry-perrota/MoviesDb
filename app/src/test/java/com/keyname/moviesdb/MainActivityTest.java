package com.keyname.moviesdb;

import static org.junit.Assert.assertTrue;

import android.content.Intent;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.shadows.ShadowActivity;

@RunWith(RobolectricTestRunner.class)
public class MainActivityTest {
    private MainActivity activity;
    @Before
    public void setup() throws Exception{
        activity = Robolectric.buildActivity(MainActivity.class)
                .create()
                .resume()
                .get();

    }
    @Test
    public void validateTextViewContent(){
        TextView appnametextView=activity.findViewById(R.id.textView);
        assertTrue("Movies".equals(appnametextView.getText().toString()));
    }
    @Test
    public void homepageActivityStarts(){
        activity.findViewById(R.id.findMovieButton).performClick();
        Intent expectedIntent= new Intent(activity,Homepage.class);
        ShadowActivity shadowActivity= org.robolectric.Shadows.shadowOf(activity);
        Intent actualIntent=shadowActivity.getNextStartedActivity();
        assertTrue(actualIntent.filterEquals(expectedIntent));
    }

}
