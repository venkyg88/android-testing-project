package com.teamtreehouse.testingbase;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by venkatgonuguntala on 7/4/16.
 */
public class MainActivityPresenterTest {

    MainActivityPresenter presenter;
    MainActivityView view;


    // Why?? It lets our app test without activity!!
    public class MockedView implements MainActivityView {
        String textViewText;
        int colorT;
        Class activityT;
        @Override
        public void changeTextViewText(String text) {
            textViewText = text;
        }

        @Override
        public void changeBackGroundColor(int color) {
            colorT = color;
        }

        @Override
        public void launchOtherActivity(Class activity) {
            activityT = activity;
        }
    }
    @Before
    public void setUp() throws Exception {
        view = new MockedView();
        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() throws Exception {
        //arrange
        String givenString = "test123";

        //act
        presenter.editTextUpdated(givenString);

        //assert
        assertEquals(givenString, ((MockedView)view).textViewText);
    }

    @Test
    public void colorSelected() throws Exception {
        //arrange
        int index = 2;
        int givenColor = Color.GREEN;

        //act
        presenter.colorSelected(index);

        //assert
        assertEquals(givenColor, ((MockedView)view).colorT);

    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {

        //arrange
        Class clazz = OtherActivity.class;

        //act
        presenter.launchOtherActivityButtonClicked(clazz);

        //assert
        assertEquals(clazz, ((MockedView)view).activityT);
    }

}