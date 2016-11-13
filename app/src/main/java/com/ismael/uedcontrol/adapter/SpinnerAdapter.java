package com.ismael.uedcontrol.adapter;

import android.content.Context;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.model.Patient;
import com.ismael.uedcontrol.repositories.PatientRepository;

import java.util.List;

/**
 * Created by ismael on 13/11/16.
 */

public class SpinnerAdapter extends ArrayAdapter<Patient>{

    private List<Patient> pats;
    public SpinnerAdapter(Context context) {
        super(context, R.layout.item_patient, PatientRepository.getInstance().getPatients());
        pats = PatientRepository.getInstance().getPatients();
    }


    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_activity, parent, false);
        TextView v = (TextView) row.findViewById(R.id.txvInfoActivity);
        v.setText(pats.get(position).toString());
        return row;

    }



    @Override
    public View getDropDownView(int position, View convertView, ViewGroup parent) {

        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View row = inflater.inflate(R.layout.item_activity, parent, false);
        TextView v = (TextView)row.findViewById(R.id.txvInfoActivity);

        v.setText(pats.get(position).toString());
        return row;
    }
}
