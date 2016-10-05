package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by watts1 on 9/13/16.
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
