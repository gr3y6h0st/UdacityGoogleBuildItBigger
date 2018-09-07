package com.udacity.gradle.builditbigger;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;
import android.util.Log;

import org.junit.Test;
import org.junit.runner.RunWith;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;

@RunWith(AndroidJUnit4.class)
public class EndpointsAsyncTaskTest {

    @Test
    public void endpointsAsyncTaskTest() throws Exception {
        /**
         * Had trouble getting the AsyncTask to execute properly,
         * so I constructed the AsyncTask to take a context argument,
         * which initializes via InstrumentationRegistry below
         * based off this SO post answer provided by user: Keerthana S
         * Source: https://stackoverflow.com/questions/2321829/android-asynctask-testing-with-android-test-framework
         */
        Context context = InstrumentationRegistry.getContext();

        //create new EndpointsAsyncTask(with context argument)
        EndpointsAsyncTask  asyncTask = new EndpointsAsyncTask(context);

        try {
            //run the AsyncTask
            asyncTask.execute();

            //retrieve joke string and set it to jokeString variable
            String jokeString = asyncTask.get();

            //check that jokeString var isn't null;
            assertNotNull(jokeString);
            //check that the length of string isn't empty.
            assertTrue(jokeString.length() > 0);

            System.out.println(jokeString);

            //log the result of joke string.
            Log.d("ASYNC TASK TEST: ", "FETCHING JOKE STRING " + jokeString);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}