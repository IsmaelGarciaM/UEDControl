package com.ismael.uedcontrol.model;

import java.sql.Time;
import java.util.Date;

public class Conversation {
    private int id;
    private User author;
    private User receiver;
    String message;
    Date date;
    Time time;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public Conversation(int mId, User mAuthor, User mREceiver, String mMessage, Date mDate, Time mTime){

    }

}
