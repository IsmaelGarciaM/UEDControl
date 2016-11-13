package com.ismael.uedcontrol.repositories;

import com.ismael.uedcontrol.model.Contact;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Created by ismael on 12/11/16.
 */

public class ContactRepository extends ArrayList<Contact> {
    public static ContactRepository contacRep;

    public static ContactRepository getInstance() {

        if (contacRep == null)
            contacRep = new ContactRepository();

        return contacRep;
    }

    private ContactRepository(){
        add(new Contact(0, "Antonio", "Martinez", "92196592A", "954546812", "Hermano/a", 45454, "passw"));
        add(new Contact(1, "Maria", "Torres", "92196592A", "954546812", "Cónyuge", 45454, "passw"));
        add(new Contact(2, "Miguel", "Ruiz", "92196592A", "954546812", "Hermano/a", 45454, "passw"));
        add(new Contact(3, "Ana", "Lozano", "92196592A", "954546812", "Hijo/a", 45454, "passw"));
        add(new Contact(4, "Rocío", "Sanchez", "92196592A", "954546812", "Hijo/a", 45454, "passw"));
    }

    public ArrayList getContacts(){

        ArrayList<Contact> lc = (ArrayList<Contact>) this.subList(0, this.size());
        Collections.sort(lc);

        return lc;
    }

    public ArrayList getContacts(boolean asc){
        ArrayList l = (ArrayList) this.subList(0, this.size());
        if(asc)
            Collections.sort(l);
        else{
            Comparator c = Collections.reverseOrder();
            Collections.sort(l, c);
        }
        return  l;
    }


}
