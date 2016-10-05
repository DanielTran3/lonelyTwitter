package ca.ualberta.cs.lonelytwitter;

/**
 * Class that defines important tweets. This is a subclass of Tweet.
 * @author Daniel
 * @see Tweet
 * @see NormalTweet
 */
public class ImportantTweet extends Tweet {

    /**
     * Instantiates a new Important tweet.
     *
     * @param message the message
     */
    public ImportantTweet(String message){
        super(message);
    }

    /**
     * Defines a tweet as important
     * @return true if the tweet is important (ImportantTweet).
     */
    @Override
    public Boolean isImportant(){
        return Boolean.TRUE;
    }

}
