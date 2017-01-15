package com.ismael.uedcontrol.fragments;


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
public class AddEditFood extends Fragment {

    Button btnDateFood;
    public AddEditFood() {
        // Required empty public constructor
    }

    public static AddEditFood getInstance(Bundle b){
        AddEditFood f = new AddEditFood();
        f.setArguments(b);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootV = inflater.inflate(R.layout.fragment_add_edit_food, container, false);
        btnDateFood = (Button) rootV.findViewById(R.id.btnDatePickerAdd);
        btnDateFood.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePickerFood");
            }
        });
        return rootV;
    }

}
