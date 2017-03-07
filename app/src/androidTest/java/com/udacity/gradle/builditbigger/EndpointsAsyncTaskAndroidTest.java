package com.udacity.gradle.builditbigger;

import android.test.ActivityInstrumentationTestCase2;
import android.test.MoreAsserts;

import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

import cloud_controller.EndpointsAsyncTask;

/**
 * Android Unit Test to test if the string retrieved from the cloud is not empty.
 */
@SuppressWarnings("deprecation")
public class EndpointsAsyncTaskAndroidTest extends ActivityInstrumentationTestCase2<MainActivity> {

    public EndpointsAsyncTaskAndroidTest() {
        super(MainActivity.class);
    }

    public void testIfJokeStringIsEmpty() throws Throwable {
        final EndpointsAsyncTask endpointsAsyncTask =
                new EndpointsAsyncTask();

        runTestOnUiThread(new Runnable() {
            @Override
            public void run() {
                //noinspection unchecked
                endpointsAsyncTask.execute();
            }
        });

        try {
            //get() waits for AsyncTask to complete then gets it's return value from doInBackground()
            String joke = endpointsAsyncTask.get(60, TimeUnit.SECONDS);
            //noinspection deprecation
            MoreAsserts.assertNotEqual(joke, "");

        }catch (CancellationException | ExecutionException | InterruptedException
                | TimeoutException e){
            fail("AsyncTask has failed");
        }
    }
}
