package com.ismael.uedcontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ismael.uedcontrol.adapter.PatientAdapter;
import com.ismael.uedcontrol.model.Patient;

import java.util.Collections;
import java.util.Comparator;

public class PatientListActivity extends AppCompatActivity {

    PatientAdapter adapter;
    ListView patients;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_list);

        patients = (ListView) findViewById(R.id.listPatients);
        adapter = new PatientAdapter(this);
        patients.setAdapter(adapter);

        patients.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Patient p = (Patient)parent.getItemAtPosition(position);
                Intent i = new Intent(PatientListActivity.this, PatientProfile.class );
                i.putExtra("name", p.getName());
                i.putExtra("surname", p.getSurname());
                i.putExtra("img", p.getImgProfile());
                i.putExtra("dni", p.getDni());
                i.putExtra("bdate", p.getBirthdate());
                startActivity(i);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_list, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add_patient:
                Intent i = new Intent(PatientListActivity.this, AddEditPatient.class );
                startActivity(i);
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


}
