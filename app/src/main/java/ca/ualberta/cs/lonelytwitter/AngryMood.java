package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Daniel on 2016-09-13.
 */
public class AngryMood extends CurrentMood
{
    public AngryMood()
    {
        super();
    }
    public AngryMood(Date date)
    {
        super(date);
    }

    @Override
    public String defineMood()
    {
        return "Angry";
    }
}
