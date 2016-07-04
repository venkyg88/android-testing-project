package com.teamtreehouse.testingbase;

import android.graphics.Color;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.runners.MockitoJUnitRunner;

import static org.junit.Assert.*;

/**
 * Created by venkatgonuguntala on 7/4/16.
 */
@RunWith(MockitoJUnitRunner.class)              //now Instead of using default JUnitRunner we are using Mockito runner.
public class MainActivityPresenterTest {

    MainActivityPresenter presenter;

    @Mock                                       // using Mockito to Mock
    MainActivityView view;

    @Before
    public void setUp() throws Exception {

        presenter = new MainActivityPresenter(view);
    }

    @Test
    public void editTextUpdated() throws Exception {
        //arrange
        String givenString = "test123";

        //act
        presenter.editTextUpdated(givenString);

        //assert
        Mockito.verify(view).changeTextViewText(givenString);

    }

    @Test
    public void colorSelected() throws Exception {
        //arrange
        int index = 2;
        int givenColor = Color.GREEN;

        //act
        presenter.colorSelected(index);

        //assert
        Mockito.verify(view).changeBackGroundColor(givenColor);

    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {

        //arrange
        Class clazz = OtherActivity.class;

        //act
        presenter.launchOtherActivityButtonClicked(clazz);

        //assert
        Mockito.verify(view).launchOtherActivity(clazz);
    }

}