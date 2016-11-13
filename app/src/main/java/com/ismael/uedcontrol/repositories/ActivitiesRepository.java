package com.ismael.uedcontrol.repositories;

import com.ismael.uedcontrol.model.Activitys;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;

/**
 * Created by ismael on 12/11/16.
 */

public class ActivitiesRepository extends ArrayList<Activitys> {
    public static ActivitiesRepository activiRep;

    public static ActivitiesRepository getInstance() {

        if (activiRep == null)
            activiRep = new ActivitiesRepository();

        return activiRep;
    }

    private ActivitiesRepository(){
        Date d = new Date();
        java.sql.Date da = new java.sql.Date(d.getTime());
        Time t = new Time(d.getTime());
        add(new Activitys(0, "Título", "Descripcioncilla", "Fisioterapia", da, t));
        add(new Activitys(1, "Título", "Descripcioncilla", "Terapia Ocupacional", da, t));
        add(new Activitys(2, "Título", "Descripcioncilla", "Regenarcion del alma", da, t));

    }

    public ArrayList getActivities(){

        ArrayList<Activitys> lc = (ArrayList<Activitys>) this.subList(0, this.size());
        Collections.sort(lc);

        return lc;
    }

    public ArrayList getActivities(boolean asc){
        List<Activitys> al;
        al = new ArrayList<Activitys>( this.subList(0, this.size()));
        if(asc)
            Collections.sort(al);
        else{
            Comparator c = Collections.reverseOrder();
            Collections.sort(al, c);
        }
        return  (ArrayList) al;
    }
}
