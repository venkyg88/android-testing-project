package com.teamtreehouse.testingbase;

import android.os.Build;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricGradleTestRunner;
import org.robolectric.annotation.Config;

/**
 * Created by venkatgonuguntala on 7/4/16.
 */

@RunWith(RobolectricGradleTestRunner.class)
@Config(constants = BuildConfig.class/*, sdk = Build.VERSION_CODES.LOLLIPOP*/)
public class MainActivityTest {

    @Before
    public void setUp() {

    }

    @Test
    public void editTextUpdatesTextView() throws Exception{

    }

}
