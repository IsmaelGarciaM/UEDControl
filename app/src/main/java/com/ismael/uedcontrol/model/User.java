package com.ismael.uedcontrol.model;

public class User {

    private String name;
    private String surname;
    private int imgProfile;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public User(String mName, String mSur, int img){
        this.name = mName;
        this.surname = mSur;
        this.imgProfile = img;
    }
}
