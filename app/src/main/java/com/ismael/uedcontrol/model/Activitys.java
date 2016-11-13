package com.ismael.uedcontrol.model;

import java.sql.Time;
import java.util.Date;


public class Activitys implements Comparable<Activitys>{

    private int id;
    private String title;
    private String description;
    private String type;
    private Date date ;
    private Time time;

    public Therapist getAuthor() {
        return author;
    }

    public void setAuthor(Therapist author) {
        this.author = author;
    }

    private Therapist author;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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

    public Activitys(int mId, String mTitle, String mDescription, String mType, Date mDate, Time mTime){
        this.id = mId;
        this.title = mTitle;
        this.description = mDescription;
        this.type = mType;
        this.date = mDate;
        this.time = mTime;
    }

    @Override
    public String toString() {
        return title + "\n" + description + "\n" + type + "\n" + date.toString() + "\n" + time.toString();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Activitys c = (Activitys) obj;

        if (!(id == c.id)) return false;
        else return true;
    }

    @Override
    public int compareTo(Activitys a) {
         return this.getTitle().compareTo(a.getTitle());

    }
}
