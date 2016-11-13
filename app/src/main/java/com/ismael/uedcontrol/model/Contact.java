package com.ismael.uedcontrol.model;

import java.util.ArrayList;

public class Contact extends User implements Comparable<Contact> {

    private int id;
    private String email;
    private String phone;
    private String relationship;
    private String password;

    public Patient getFamily() {
        return family;
    }

    public void setFamily(Patient family) {
        this.family = family;
    }

    private Patient family;


    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRelationship() {
        return relationship;
    }

    public void setRelationship(String relationship) {
        this.relationship = relationship;
    }

    public Contact(int mId, String mName, String mSurname, String mEmail, String mPhone, String mRelationship, int img, String mPassword){
        super(mName, mSurname, img);
        this.id = mId;
        this.email = mEmail;
        this.phone = mPhone;
        this.relationship = mRelationship;
        this.password = mPassword;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname() + " (" + relationship + ")";
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Contact c = (Contact) obj;

        if (!(id == c.id)) return false;
        else return true;
    }

    @Override
    public int compareTo (Contact c){
        if( this.getName().compareTo(c.getName()) == 0)
            return this.getSurname().compareTo(c.getSurname());
        else return this.getName().compareTo(c.getName());
    }
}

