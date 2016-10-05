package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by Daniel on 2016-09-27.
 */
public class TweetList
{
    /**
     * The Tweets.
     */
    List<Tweet> tweets = new ArrayList<Tweet>();

    /**
     * Adds a tweet, as long as the tweet does not exist.
     *
     * @param tweet the tweet.
     * @throws IllegalArgumentException
     */
    public void addTweet(Tweet tweet) {

        if (hasTweet(tweet) == true)
        {
            throw new IllegalArgumentException();

        }

        tweets.add(tweet);

    }

    /**
     * Checks is there is a currently the same tweet in the list
     *
     * @param tweet the tweet
     * @return the boolean True if the tweet exists, false if the tweet doesn't exist
     */
    public boolean hasTweet(Tweet tweet)
    {
        for (int i = 0; i < tweets.size(); i++)
        {
            if (tweets.get(i).equals(tweet))
            {
                return true;
            }
        }
        return tweets.contains(tweet);
    }

    /**
     * Gets a tweet at the given index
     *
     * @param i the index
     * @return the tweet
     */
    public Tweet getTweet(int i)
    {
        return tweets.get(i);
    }

    /**
     * Delete a tweet.
     *
     * @param a the the tweet, delete it from the list.
     */
    public void delete(Tweet a)
    {
        tweets.remove(a);
    }

    /**
     * Gets the list of tweets in sorted order.
     *
     * @return the the sorted list of tweets
     */
    public List<Tweet> getTweets()
    {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet tweet2) {
                return tweet.getDate().compareTo(tweet2.getDate());
            }
        });

        return tweets;
    }

    /**
     * Gets the number of tweets in TweetList.
     *
     * @return the the number of tweets.
     */
    public int getCount()
    {
        return tweets.size();
    }
}
