package com.ismael.uedcontrol.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ListView;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.adapter.PatientAdapter;

public class AddEditActivitys extends Fragment {

    Button btnDateActivity;
    PatientAdapter adapter;
    ListView listPatientForActivity;
    public static AddEditActivitys getInstance(Bundle args){
        AddEditActivitys f = new AddEditActivitys();
        f.setArguments(args);
        return  f;
    }

    public AddEditActivitys() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootV = inflater.inflate(R.layout.fragment_add_edit_activitys, container, false);
        listPatientForActivity = (ListView) rootV.findViewById(R.id.listPatient) ;
        adapter = new PatientAdapter(this.getContext());
        listPatientForActivity.setAdapter(adapter);
        btnDateActivity = (Button) rootV.findViewById(R.id.btnDateActivity);
        btnDateActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePickerAct");
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

}
