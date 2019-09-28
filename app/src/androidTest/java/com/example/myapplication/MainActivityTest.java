package com.example.myapplication;

import android.app.Activity;
import android.support.test.rule.ActivityTestRule;
import android.view.View;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;

import static org.junit.Assert.*;

public class MainActivityTest {
    @Rule
    public ActivityTestRule<MainActivity> obj=new ActivityTestRule<>(MainActivity.class);
    private MainActivity mainActivity=null;
    @Before
    public void setUp()throws Exception{
        mainActivity=obj.getActivity();

    }
    @Test
    public void testLaunch(){
        View v=mainActivity.findViewById(R.id.txt);
        assertNotNull(v);
    }
    @After
    public void tearDown()throws Exception{

    }
@Test
    public void onCreate(){

}

}