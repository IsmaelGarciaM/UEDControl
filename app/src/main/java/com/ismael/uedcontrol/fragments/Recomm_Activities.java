package com.ismael.uedcontrol.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.adapter.ActAdapter;
import com.ismael.uedcontrol.adapter.SpinnerAdapter;

/**
 * A simple {@link Fragment} subclass.
 */
public class Recomm_Activities extends Fragment {

    Spinner spnNamePatients;
    SpinnerAdapter adapter;
    IRecActivitiesListener mCallback;
    RecyclerView rv;
    ActAdapter adapterAct;

    public static Recomm_Activities getInstance(Bundle args){
        Recomm_Activities f = new Recomm_Activities();
        f.setArguments(args);
        return  f;
    }
    public Recomm_Activities() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View rootV = inflater.inflate(R.layout.fragment_recomm__activities, container, false);

        spnNamePatients = (Spinner) rootV.findViewById(R.id.spnSelPatient);
        adapter = new SpinnerAdapter(this.getContext());
        spnNamePatients.setAdapter(adapter);
        rv = (RecyclerView) rootV.findViewById(R.id.listRecommendedActivities);
        rv.setLayoutManager(new LinearLayoutManager(this.getContext()));
        adapterAct = new ActAdapter();
        rv.setAdapter(adapterAct);
        return rootV ;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_food, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_patient:
                mCallback.addActivity();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (IRecActivitiesListener) activity;
    }


    public interface IRecActivitiesListener {

        void addActivity();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        adapter = null;
        adapterAct = null;
    }
}
