package com.teamtreehouse.testingbase;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Build;
import android.view.inputmethod.EditorInfo;

import org.apache.tools.ant.Main;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.Shadows;
import org.robolectric.annotation.Config;
import org.robolectric.shadows.ShadowActivity;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by venkatgonuguntala on 7/4/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class, sdk = Build.VERSION_CODES.LOLLIPOP)
public class MainActivityTest {

    private MainActivity activity;

    @Before
    public void setUp() {
        activity = Robolectric.setupActivity(MainActivity.class);
    }

    @Test
    public void editTextUpdated() throws Exception {
        //arrange
        String givenString = "test123";
        activity.editText.setText(givenString);

        //act
        activity.editText.onEditorAction(EditorInfo.IME_ACTION_DONE);

        //assert
        String actualString = activity.textView.getText().toString();
        assertEquals(givenString, actualString);

    }

    @Test
    public void spinnerUpdatesBackgroundColor() throws Exception {
        //arrange
        int index =2;
        int givenColor = Color.GREEN;

        //act
        activity.colorSpinner.setSelection(index);

        //assert
        int actualColor = ((ColorDrawable) activity.linearLayout.getBackground()).getColor();
        assertEquals(givenColor, actualColor);
    }

    @Test
    public void buttonLaunchesOtherActivity() throws Exception {
        //arrange
        Class clazz = OtherActivity.class;
        Intent expectedIntent = new Intent(activity, clazz);

        //act
        activity.launchActivityButton.callOnClick();

        //assert
        //getNextStartedActivity() - ShadowActivity method can we use to find the Intent of the Activity
        // we have just started
        //A good way to think about shadows is like a mock with little extra functionality
        ShadowActivity shadowActivity = Shadows.shadowOf(activity);
        Intent actualIntent = shadowActivity.getNextStartedActivity();
       // assertEquals(expectedIntent, intent);// Error: intents can have small differences which can make seemingly
                                            //identical intents not equal to one another. There fore ---->//
        //using filterEquals from intents to check they are equal from functional standpoint

        assertTrue(expectedIntent.filterEquals(actualIntent));
    }
}
