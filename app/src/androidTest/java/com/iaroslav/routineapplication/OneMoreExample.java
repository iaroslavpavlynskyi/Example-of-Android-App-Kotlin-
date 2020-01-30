package com.iaroslav.routineapplication;

import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.uiautomator.By;
import androidx.test.uiautomator.UiDevice;
import androidx.test.uiautomator.UiObject2;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import static androidx.test.platform.app.InstrumentationRegistry.getInstrumentation;
import static org.junit.Assert.assertFalse;

@RunWith(AndroidJUnit4.class)
public class OneMoreExample {
    private static final String BASIC_PACKAGE
            = "com.iaroslav.routineapplication.MainActivity";

    private UiDevice myDevice;

    @Before
    public void setUp(){
        myDevice = UiDevice.getInstance(getInstrumentation());
        myDevice.pressHome();
    }

    @Test
    public void testExample() {
        UiObject2 recyclerView
                = myDevice.findObject(By.res(BASIC_PACKAGE,"rv_menu"));
        String someText = recyclerView.getChildren().get(0).getText();
        boolean isEmpty = someText.equals("");
        assertFalse("Item is empty", isEmpty);

    }
}
