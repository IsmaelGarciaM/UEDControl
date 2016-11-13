package com.ismael.uedcontrol.model;

import java.util.ArrayList;
import java.util.Date;


public class Patient extends User implements Comparable<Patient>{
    private String dni;
    private Date birthdate;

    public Contact getFamily() {
        return family;
    }

    public void setFamily(Contact family) {
        this.family = family;
    }

    private Contact family;
    private ArrayList<Therapist> theraphist;

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
        super(mName, mSurname, mImg);
        this.dni = mDni;
        this.birthdate = mBirthdate;
    }

    @Override
    public String toString() {
        return this.getName() + " " + this.getSurname();
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

}
