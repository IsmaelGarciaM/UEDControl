package com.ismael.uedcontrol.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.adapter.PatientAdapter;
import com.ismael.uedcontrol.model.Patient;

import java.util.Comparator;


public class PatientList extends ListFragment {


    PatientAdapter adapter;
    ListView patients;
    TextView emptyList;
    IListPatientListener mCallback;

    public static PatientList getInstance(Bundle args){
        PatientList f = new PatientList();
        f.setArguments(args);
        return  f;
    }

    @Override
    public void onCreate(Bundle savedInstance){
        super.onCreate(savedInstance);
        adapter = new PatientAdapter(getContext());
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
        View rootView = inflater.inflate(R.layout.fragment_patient_list, container, false);
        emptyList = (TextView)rootView.findViewById(android.R.id.empty);
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
                mCallback.addPatient();
                break;

            case R.id.action_sort_alphabetically:
                adapter.sort(new Comparator<Patient>() {
                    @Override
                    public int compare(Patient o1, Patient o2) {
                        return o1.compareTo(o2);
                    }
                });
                break;

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        patients = getListView();
        patients.setAdapter(adapter);

        patients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Patient p = (Patient) parent.getItemAtPosition(position);
                //Intent i = new Intent(getParentFragment().getContext(), PatientProfile.class);
                Bundle b = new Bundle();
                b.putParcelable("patient", p);
                mCallback.showPatientProfile(b);
            }
        });
    }



    @Override
    public void onDestroy(){
        super.onDestroy();
        adapter = null;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (IListPatientListener)activity;
    }


    public interface IListPatientListener{

        void showPatientProfile(Bundle patient);
        void addPatient();
        //void showManageProduct(Bundle bundle);
        //void showDeletePopUp(Product product);
        //void undoDeleting(Product product);
    }

}
