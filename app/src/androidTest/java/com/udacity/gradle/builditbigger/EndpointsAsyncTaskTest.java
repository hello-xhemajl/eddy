package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.filters.MediumTest;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;

import helo.mali.eddy.EndpointsAsyncTask;

import static org.hamcrest.Matchers.isEmptyOrNullString;
import static org.hamcrest.Matchers.not;
import static org.junit.Assert.*;

@MediumTest
@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    private Context instrumentationCtx;

    @Before
    public void setup() {
        instrumentationCtx = InstrumentationRegistry.getContext();
    }

    @Test
    public void asyncTask_retrieves_nonEmptyString(){

        // Kick of the AsyncTask
        new EndpointsAsyncTask(new EndpointsAsyncTask.OnBackEndResponseListener() {
            @Override
            public void onBackEndResponse(String result) {
                // Is the AsyncTask result non-empty?
                assertThat(result, not(isEmptyOrNullString()));
            }
        }, instrumentationCtx).execute();
    }
}