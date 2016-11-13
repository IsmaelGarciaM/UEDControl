package com.ismael.uedcontrol.model;


import java.util.ArrayList;

public class Therapist extends User {

    private String dni;
    private String type;
    private String email;
    private String phone;
    private String password;

    public ArrayList<Patient> getPatients() {
        return patients;
    }

    public void setPatients(ArrayList<Patient> patients) {
        this.patients = patients;
    }

    private ArrayList<Patient> patients;

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String DNI) {
        this.dni = DNI;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }


    public Therapist(String mName, String mSurname, String mDni, String mEmail, String mPhone, int img, String mPass){
        super(mName, mSurname, img);
        this.dni = mDni;
        this.email = mEmail;
        this.phone = mPhone;
        this.password = mPass;

    }

    @Override
    public String toString() {
        return this.getName() +" "+this.getSurname();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;

        Therapist t = (Therapist)obj;

        if (!dni.equals(t.dni)) return false;
        else return true;


    }
}
