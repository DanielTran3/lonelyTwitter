package ca.ualberta.cs.lonelytwitter;

import android.test.ActivityInstrumentationTestCase2;

import java.util.Date;

/**
 * Created by Daniel on 2016-09-27.
 */
public class TweetListTest extends ActivityInstrumentationTestCase2<LonelyTwitterActivity>
{
    public TweetListTest()
    {
        super(LonelyTwitterActivity.class);
    }

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

    public void testHasTweet()
    {
        TweetList list = new TweetList();

        Tweet tweet = new NormalTweet("Hello!");

        assertFalse(list.hasTweet(tweet));
        list.addTweet(tweet);
        assertTrue(list.hasTweet(tweet));
    }

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

    public void testDeleteTweet()
    {
        TweetList list = new TweetList();

        Tweet a = new NormalTweet("Hello!");
        list.addTweet(a);
        assertTrue(list.hasTweet(a));

        list.delete(a);
        assertFalse(list.hasTweet(a));
    }

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
