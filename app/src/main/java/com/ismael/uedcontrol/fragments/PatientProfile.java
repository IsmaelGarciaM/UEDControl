package com.ismael.uedcontrol.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.model.Patient;

/**
 * A simple {@link Fragment} subclass.
 */
public class PatientProfile extends Fragment {


    TextView n;
    TextView sn;
    TextView _dni;
    ImageView _img;
    TextView date;

    Button btnNewContact;

    IPatientProfileListener mCallback;



    public static PatientProfile getInstance(Bundle args){
        PatientProfile f = new PatientProfile();
        f.setArguments(args);
        return  f;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        setRetainInstance(true);

        /**
         * Esta opcion le dice a la actitivity que este fragment tiene su propio menu y llama a todos
         * los métodos de los fragments.
         */
        setHasOptionsMenu(true);
    }

    public PatientProfile() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootV =inflater.inflate(R.layout.fragment_patient_profile, container, false);
        n = (TextView) rootV.findViewById(R.id.txvPatientName);
        sn = (TextView) rootV.findViewById(R.id.txvPatientSurname);
        _dni = (TextView) rootV.findViewById(R.id.txvPatientDni);
        _img = (ImageView) rootV.findViewById(R.id.imgPatient);
        date = (TextView) rootV.findViewById(R.id.txvPatientBirthDate);
        btnNewContact = (Button) rootV.findViewById(R.id.btnAddContactProfile);
        Patient p = getArguments().getParcelable("patient");
        n.setText(p.getName().toString());
        sn.setText(p.getSurname());
        _dni.setText(p.getDni());
      //  date.setText(p.getBirthdate().toString());
        _img.setImageResource(p.getImgProfile());

        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               // Intent i = new Intent(PatientProfile.this, AddEditContact.class);
                //startActivity(i);
                mCallback.addContact();
            }
        });
        return rootV;
    }

    public interface IPatientProfileListener{
        void addContact();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (IPatientProfileListener)activity;
    }
}
