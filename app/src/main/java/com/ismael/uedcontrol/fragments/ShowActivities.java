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

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.adapter.ActAdapter;


public class ShowActivities extends Fragment {

    ActAdapter adapter;
    RecyclerView activities;
    IListActivitiesListener mCallback;



    public static ShowActivities getInstance(Bundle b) {
        ShowActivities f = new ShowActivities();
        f.setArguments(b);
        return f;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        adapter = new ActAdapter();
        setRetainInstance(true);

        /**
         * Esta opcion le dice a la actitivity que este fragment tiene su propio menu y llama a todos
         * los métodos de los fragments.
         */
        setHasOptionsMenu(true);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle args) {
        //super.onCreateView(inflater, container,  args);
        View rootView = inflater.inflate(R.layout.fragment_show_activities, container, false);
        activities = (RecyclerView) rootView.findViewById(R.id.ActRecycler);
        LinearLayoutManager llm =new LinearLayoutManager(this.getContext());
        activities.setLayoutManager(llm);

        activities.setAdapter(adapter);
        return rootView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_list, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_patient:
                mCallback.addActivity();
                break;

            case R.id.action_sort_alphabetically:
                adapter.getActivitiesOrder();
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onDestroy(){
        super.onDestroy();
        adapter = null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (IListActivitiesListener) activity;
    }


    public interface IListActivitiesListener{

        void showActivities();
        void addActivity();
        //void addPatient();
        //void showManageProduct(Bundle bundle);
        //void showDeletePopUp(Product product);
        //void undoDeleting(Product product);
    }
}
