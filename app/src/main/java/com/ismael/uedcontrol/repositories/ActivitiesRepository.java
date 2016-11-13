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
        add(new Activitys(0, "Taller libre", "Se proporcionan diversos materiales para estimular la creatividad", "Taller libre", da, t));
        add(new Activitys(1, "Bingo", "Juego clásico del bingo", "Estimulación cognitiva", da, t));
        add(new Activitys(2, "Gerontogimnasia", "Actividades físicas como calentamientos, relajacion, caminar...", "Psicomotricidad", da, t));

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
