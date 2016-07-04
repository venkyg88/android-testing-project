package com.teamtreehouse.testingbase;

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
        @Override
        public void changeTextViewText(String text) {
            textViewText = text;
        }

        @Override
        public void changeBackGroundColor(int color) {

        }

        @Override
        public void launchOtherActivity(Class activity) {

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

    }

    @Test
    public void launchOtherActivityButtonClicked() throws Exception {

    }

}