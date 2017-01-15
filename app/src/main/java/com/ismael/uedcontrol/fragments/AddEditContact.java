package com.ismael.uedcontrol.fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.ismael.uedcontrol.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditContact extends Fragment {


    public AddEditContact() {
        // Required empty public constructor
    }

    public static AddEditContact getInstance(Bundle args){
        AddEditContact f = new AddEditContact();
        f.setArguments(args);
        return  f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_add_edit_contact, container, false);
    }



}
