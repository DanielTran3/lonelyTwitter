package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * The base class that defines a Tweet.
 */
public abstract class Tweet {
    private String message;
    private Date date;

    /**
     * Instantiates a new Tweet if only message is given as a parameter.
     *
     * @param message the message
     */
    public Tweet(String message){
        this.message = message;
        this.date = new Date();
    }

    /**
     * Instantiates a new Tweet if message and date are given as parameters.
     *
     * @param message the message
     * @param date    the date
     */
    public Tweet(String message, Date date){
        this.message = message;
        this.date = date;
    }


    /**
     * Defines an abstract function called isImportant that is
     * used in ImportantTweet and NormalTweet.
     *
     * @return the boolean
     */
    public abstract Boolean isImportant();

    /**
     * Sets message of less that 140 characters in length.
     *
     * @param message the message
     * @throws TweetTooLongException the tweet too long exception
     */
    public void setMessage(String message) throws TweetTooLongException {
        if (message.length() > 140) {
            //Do something
            throw new TweetTooLongException();
        }
        this.message = message;
    }

    /**
     * Sets date of the tweet.
     *
     * @param date the date
     */
    public void setDate(Date date) {
        this.date = date;
    }

    /**
     * Gets a tweet's message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Gets the date of the tweet.
     *
     * @return the date
     */
    public Date getDate() {
        return date;
    }

    /**
     * Overrides the toString() method to print the date, followed by | and the message.
     * @return date.toString() + " | " + message
     */
    @Override
    public String toString(){
        return  date.toString() + " | " + message;
    }
}
