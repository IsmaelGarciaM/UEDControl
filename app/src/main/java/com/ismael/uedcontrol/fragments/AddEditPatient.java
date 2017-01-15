package com.ismael.uedcontrol.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ismael.uedcontrol.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class AddEditPatient extends Fragment {


    Button btnAddContact;
    Button btnBdatePicker;
    IAddContactListener mCallback;

    public static AddEditPatient getInstance(Bundle args){
        AddEditPatient f = new AddEditPatient();
        f.setArguments(args);
        return  f;
    }

    public AddEditPatient() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootV = inflater.inflate(R.layout.fragment_add_edit_patient, container, false);
        btnAddContact = (Button) rootV.findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              //  Intent i = new Intent(AddEditPatient.this, AddEditContact.class);
                //startActivity(i);
                mCallback.addContact();
            }
        });

        btnBdatePicker = (Button) rootV.findViewById(R.id.btnBirthdatePicker);
        btnBdatePicker.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePicker");
            }
        });
        return rootV;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setRetainInstance(true);
        setHasOptionsMenu(true);
    }

    public interface IAddContactListener{
        void addContact();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (IAddContactListener)activity;
    }
}





