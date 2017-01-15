package com.ismael.uedcontrol.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.ismael.uedcontrol.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFood extends Fragment {

    Button b;
    IAddMenuListener mCallback;
    public ShowFood() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
    }

    public static ShowFood getInstance(Bundle b){
        ShowFood f = new ShowFood();
        f.setArguments(b);
        return f;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootV = inflater.inflate(R.layout.fragment_show_food, container, false);
        b = (Button) rootV.findViewById(R.id.btnDatePicker);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment newFragment = new SelectDateFragment();
                newFragment.show(getFragmentManager(), "DatePickerFood");
            }
        });
        return rootV;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_food, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add:
                mCallback.addMenu();
                break;

        }
        return super.onOptionsItemSelected(item);

    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (IAddMenuListener) activity;
    }


    public interface IAddMenuListener {
        void addMenu();
    }
}
