package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Test for The TweetList class. This test will test
 * <ul>
 *     <li>Adding tweets to tweetList</li>
 *     <li>If a tweetList has a tweet</li>
 *     <li>Grabbing a tweet from the tweetList</li>
 *     <li>Deleting a tweet from tweetList</li>
 *     <li>Getting the tweetList containing all of the tweets</li>
 *     <li>Getting the number of tweets in the tweetList</li>
 * </ul>
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{
    /**
     * Super the LonelyTwitterActivity class
     * @see LonelyTwitterActivity
     */
    public TweetListTest()
    {
        super(LonelyTwitterActivity.class);
    }

    /**
     * Test to add in a tweet to the tweet list. If there is a failure.
     * @throws IllegalArgumentException
     */
    public void testAddTweet()
    {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello");
        list.addTweet(tweet);

        try
        {
            list.addTweet(tweet);
            fail();
        }
        catch (IllegalArgumentException e)
        {

        }

    }

    /**
     * Check if tweetList has a tweet in it. Check before and after the tweet has been added.
     */
    public void testHasTweet()
    {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");

        assertFalse(list.hasTweet(tweet));
        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));
    }

    /**
     * Tests getting a tweet from tweetList to see if the tweet that was returned is ordered
     * correctly
     */
    public void testGetTweet()
    {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.addTweet(a);
        list.addTweet(b);

        assertEquals(list.getTweet(0), a);
        assertEquals(list.getTweet(1), b);

    }

    /**
     * Delete a tweet from tweet list and see if the tweet is still present in the list.
     */
    public void testDeleteTweet()
    {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        list.addTweet(a);
        assertTrue(list.hasTweet(a));

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

    /**
     * Test to return the TweetList and wee if the Tweets returned contain the correct data.
     */
    public void testGetTweets()
    {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");
        a.setDate(new Date(100));
        b.setDate(new Date(1000));

        list.addTweet(b);
        list.addTweet(a);

        assertTrue(list.hasTweet(a));
        assertTrue(list.hasTweet(b));

        Date tweeta = list.getTweets().get(0).getDate();
        Date tweetb = list.getTweets().get(1).getDate();
        assertTrue(tweeta.before(tweetb));
    }

    /**
     * Test to see if the number of tweets in the TweetList is correct.
     */
    public void testGetCount()
    {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        Tweet b = new NormalTweet("Hi!");

        list.addTweet(a);
        list.addTweet(b);

        assertTrue(list.getCount() == 2);
    }
}
