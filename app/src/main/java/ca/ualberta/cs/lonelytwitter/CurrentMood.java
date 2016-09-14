package ca.ualberta.cs.lonelytwitter;

import java.util.Date;

/**
 * Created by Daniel on 2016-09-13.
 */
public abstract class CurrentMood
{
    private Date date;
    private Date defaultDate = new Date();

    public CurrentMood()
    {
        this.date = defaultDate;
    }

    public CurrentMood(Date date)
    {
        this.date = date;
    }

    public abstract String defineMood();

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

}
