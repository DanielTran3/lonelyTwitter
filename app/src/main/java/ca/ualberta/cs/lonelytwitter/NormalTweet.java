package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Class that defines normal tweets. This is a subclass of Tweet.
 * @author Daniel
 * @see Tweet
 * @see ImportantTweet
 */
public class NormalTweet extends Tweet implements Tweetable {

    /**
     * This constructor makes a normalTweet with given string parameter
     *
     * @param message this parameter is the given string for the tweet. If it is set to empty
     *                string then it will be replaced by ...
     */
    public NormalTweet(String message){
        super(message);
    }

    /**
     * Instantiates a new Normal tweet.
     *
     * @param message the message
     * @param date    the date
     */
    public NormalTweet(String message, Date date) {
        super(message, date);
    }

    /**
     * Defines a tweet as not important
     * @return false if the tweet is not important (NormalTweet).
     */
    @Override
    public Boolean isImportant() {
        return Boolean.FALSE;
    }
}
