package com.udacity.gradle.builditbigger;

import android.support.v4.util.Pair;
import android.test.AndroidTestCase;
import android.util.Log;

import java.util.List;

/**
 * Created by itl on 14/07/2015.
 */
public class AsyncTaskAndroidTest extends AndroidTestCase implements AsyncResponse {

    public   String TEST_STRING ;
    public String expectedOutput;


    @Override
    public void setUp() throws Exception {
        super.setUp();
        TEST_STRING = "I am only testing. Don't laugh yet!";
        expectedOutput = "";

    }


    public void testVerifyAsyncRetrievesString() throws Exception {
        Log.e("Delegate and Context:", this.toString() + getContext().toString());
        new EndpointsAsyncTask(this, getContext()).execute(new Pair<>(getContext(), TEST_STRING));

        Thread.sleep(30000);

            Log.e("TEST JOKE OUTPUT", expectedOutput);

        assertEquals(expectedOutput, TEST_STRING);
    }

    @Override
    public void processFinish(List<String> output) {
        expectedOutput = output.get(0);
        Log.e("OUT", expectedOutput);

        //return null;
    }
}
