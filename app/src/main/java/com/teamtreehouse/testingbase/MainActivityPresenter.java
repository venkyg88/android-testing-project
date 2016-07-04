package com.teamtreehouse.testingbase;

import android.graphics.Color;

/**
 * Created by venkatgonuguntala on 7/4/16.
 */

public class MainActivityPresenter {

    private MainActivityView view;

    public MainActivityPresenter( MainActivityView view) {
        this.view = view;
    }

    public void editTextUpdated(String text) {
        view.changeTextViewText(text);
    }

    public void colorSelected(int index) {
        switch (index) {
            case 0:
                view.changeBackGroundColor(Color.WHITE);
                break;
            case 1:
                view.changeBackGroundColor(Color.MAGENTA);
                break;
            case 2:
                view.changeBackGroundColor(Color.GREEN);
                break;
            case 3:
                view.changeBackGroundColor(Color.CYAN);
                break;
        }
    }

    public void launchOtherActivityButtonClicked(Class activity) {
        view.launchOtherActivity(activity);
    }
}
