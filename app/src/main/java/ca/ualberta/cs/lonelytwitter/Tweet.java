/**
 * Created by Daniel on 2016-09-13.
 */
package ca.ualberta.cs.lonelytwitter;

import java.util.ArrayList;
import java.util.Date;

public abstract class Tweet
{
    private String message;
    private Date date;
    private ArrayList<CurrentMood> moodList;

    public Tweet(String message)
    {
        this.message = message;
    }

    public Tweet(String message, Date date)
    {
        this.message = message;
        this.date = date;
    }

    public abstract Boolean isImportant();

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140)
        {
            throw new TweetTooLongException();
        }

        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void addMood(CurrentMood mood)
    {
        this.moodList.add(mood);
    }
}

