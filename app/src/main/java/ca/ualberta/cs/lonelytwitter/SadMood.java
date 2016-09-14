package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Daniel on 2016-09-13.
 */
public class SadMood extends CurrentMood
{
    public SadMood()
    {
        super();
    }

    public SadMood(Date date)
    {
        super(date);
    }

    public String defineMood()
    {
        return "Sad";
    }
}
