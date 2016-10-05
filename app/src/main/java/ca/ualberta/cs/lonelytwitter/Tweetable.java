package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * An interface that is implemented by NormalTweet and defines the functions for getMessage and
 * getDate
 * @author Daniel
 * @see NormalTweet
 * @see #getMessage()
 * @see #getDate()
 */
public interface Tweetable {

    /**
     * Gets message.
     *
     * @return the message as a String
     */
    public String getMessage();

    /**
     * Gets date.
     *
     * @return the date as a Date
     */
    public Date getDate();
}
