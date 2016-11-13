package com.ismael.uedcontrol.repositories;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.model.Patient;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;


public class PatientRepository extends ArrayList<Patient> {
    public static PatientRepository patientRep;

    public static PatientRepository getInstance(){

        if(patientRep == null)
            patientRep = new PatientRepository();

        return patientRep;
    }

    private PatientRepository(){
        Date d = new Date();
        java.sql.Date da = new java.sql.Date(d.getTime());
        add(new Patient("Antonio", "Martinez", "92196592A", da, R.drawable.img));
        add(new Patient("Pedro", "Garcia", "75846592A", da,  R.drawable.img));
        add(new Patient("Manuel", "Soria", "78451236C", da,  R.drawable.img));
        add(new Patient("Joaquin", "Fernandez", "63254795V", da,  R.drawable.img));
        add(new Patient("Ramón", "Garcia", "96595214G", da,  R.drawable.img));

    }


    public ArrayList getPatients(){
        List lp;
         lp = new ArrayList(this.getInstance().subList(0, this.size()));

        return (ArrayList) lp;
    }

    public ArrayList getPatients(boolean asc){
        List l;
        l = new ArrayList( this.getInstance().getPatients());
        if(asc)
            Collections.sort(l);
        else{
            Comparator c = Collections.reverseOrder();
            Collections.sort(l, c);
        }

        return  (ArrayList) l;
    }

}
