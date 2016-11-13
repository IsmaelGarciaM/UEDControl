package com.ismael.uedcontrol.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.ismael.uedcontrol.repositories.PatientRepository;
import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.model.Patient;

import java.util.ArrayList;
import java.util.List;


public class PatientAdapter extends ArrayAdapter<Patient>{
    public static boolean ASC = false;
    private List patients;

    public PatientAdapter(Context context) {
        super(context, R.layout.item_patient, PatientRepository.getInstance().getPatients());
        patients = PatientRepository.getInstance().getPatients();
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        PatientHolder ph ;

        if(item == null) {
            LayoutInflater ltInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

            item = ltInflater.inflate(R.layout.item_patient, null);
            ph = new PatientHolder();

            ph.patient_image = (ImageView) item.findViewById(R.id.imgPatient);
            ph.txvPatientName = (TextView) item.findViewById(R.id.txvNamePatient);
            item.setTag(ph);
        }
        else
            ph = (PatientHolder) item.getTag();

        ph.patient_image.setImageResource(getItem(position).getImgProfile());
        ph.txvPatientName.setText(getItem(position).toString());

        return item;

    }

    class PatientHolder{
        ImageView patient_image;
        TextView txvPatientName;
    }


}
