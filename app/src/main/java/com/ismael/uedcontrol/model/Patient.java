package com.ismael.uedcontrol.model;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.Date;


public class Patient implements Comparable<Patient>, Parcelable{

    private String name;
    private String surname;
    private int imgProfile;
    private String dni;
    private Date birthdate;
    private Contact family;
    private ArrayList<Therapist> theraphist;

    protected Patient(Parcel in) {
        name = in.readString();
        surname = in.readString();
        imgProfile = in.readInt();
        dni = in.readString();
    }

    public static final Creator<Patient> CREATOR = new Creator<Patient>() {
        @Override
        public Patient createFromParcel(Parcel in) {
            return new Patient(in);
        }

        @Override
        public Patient[] newArray(int size) {
            return new Patient[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public int getImgProfile() {
        return imgProfile;
    }

    public void setImgProfile(int imgProfile) {
        this.imgProfile = imgProfile;
    }

    public Contact getFamily() {
        return family;
    }

    public void setFamily(Contact family) {
        this.family = family;
    }


    public ArrayList<Therapist> getTheraphist() {
        return theraphist;
    }

    public void setTheraphist(ArrayList<Therapist> theraphist) {
        this.theraphist = theraphist;
    }


    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public Date getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(Date birthdate) {
        this.birthdate = birthdate;
    }

    public Patient(String mName, String mSurname, String mDni, Date mBirthdate, int mImg){
        this.name = mName;
        this.surname = mSurname;
        this.imgProfile = mImg;
        this.dni = mDni;
        this.birthdate = mBirthdate;
    }

    @Override
    public String toString() {
        String nombreContactO = "null";
        try {
            nombreContactO = getFamily().getName() + " " + getFamily().getSurname();
        }catch (Exception e){}

        if(nombreContactO.equals("null"))
            nombreContactO = "No existe familiar asociado." ;
        return this.getName() + " " + this.getSurname() + "\n\nFamiliar : " + nombreContactO;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Patient p = (Patient) obj;

        if (!dni.equals(p.dni)) return false;
        else return true;


    }

    @Override
    public int compareTo (Patient p){
        if( this.getName().compareTo(p.getName()) == 0)
            return this.getSurname().compareTo(p.getSurname());
        else return this.getName().compareTo(p.getName());
    }

    @Override
    public int describeContents() {
        return hashCode();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.name);
        dest.writeString(this.surname);
        dest.writeString(this.dni);
        dest.writeInt(this.imgProfile);
    }
}
