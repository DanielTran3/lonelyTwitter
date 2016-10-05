package ca.ualberta.cs.lonelytwitter;

import android.app.Activity;
import android.test.ActivityInstrumentationTestCase2;

import junit.framework.TestCase;

/**
 * Test to create a the LonelyTwitterActivity and get the activity from it to see if it is the
 * correct activity.
 */
public class LonelyTwitterActivityTest extends ActivityInstrumentationTestCase2 {

    /**
     * Super the LonelyTwitterActivity
     */
    public LonelyTwitterActivityTest() {
        super(ca.ualberta.cs.lonelytwitter.LonelyTwitterActivity.class);
    }

    /**
     * get the activity
     * @throws Exception
     */
    public void testStart() throws Exception {
        Activity activity = getActivity();

    }
}