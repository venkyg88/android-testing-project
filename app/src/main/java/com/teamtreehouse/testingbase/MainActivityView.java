package com.teamtreehouse.testingbase;

/**
 * Created by venkatgonuguntala on 7/4/16.
 */

public interface MainActivityView {
    void changeTextViewText(String text);
    void changeBackGroundColor(int color);
    void launchOtherActivity(Class activity);
}
