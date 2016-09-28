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
    List<Tweet> tweets = new ArrayList<Tweet>();

    public void addTweet(Tweet tweet) {

        if (hasTweet(tweet) == true)
        {
            throw new IllegalArgumentException();

        }

        tweets.add(tweet);

    }

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

    public Tweet getTweet(int i)
    {
        return tweets.get(i);
    }

    public void delete(Tweet a)
    {
        tweets.remove(a);
    }

    public List<Tweet> getTweets()
    {
        Collections.sort(tweets, new Comparator<Tweet>() {
            public int compare(Tweet tweet, Tweet tweet2) {
                return tweet.getDate().compareTo(tweet2.getDate());
            }
        });

        return tweets;
    }

    public int getCount()
    {
        return tweets.size();
    }
}
