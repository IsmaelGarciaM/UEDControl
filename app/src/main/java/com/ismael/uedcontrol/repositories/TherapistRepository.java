package com.ismael.uedcontrol.repositories;

import android.widget.ListView;

import com.ismael.uedcontrol.model.Therapist;

import java.util.ArrayList;

/**
 * Created by ismael on 12/11/16.
 */

public class TherapistRepository extends ArrayList<Therapist> {

    public static TherapistRepository therapistRep;

    public static TherapistRepository getInstance(){

        if(therapistRep == null)
            therapistRep = new TherapistRepository();

        return therapistRep;
    }



}
