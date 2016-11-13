package com.ismael.uedcontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Spinner;

import com.ismael.uedcontrol.adapter.PatientAdapter;
import com.ismael.uedcontrol.adapter.SpinnerAdapter;

public class RecommendedActivities extends AppCompatActivity {

    Spinner spnNamePatients;
    SpinnerAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recommended_activities);

        spnNamePatients = (Spinner) findViewById(R.id.spnSelPatient);
        adapter = new SpinnerAdapter(this);
        spnNamePatients.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_food, menu);
        return super.onCreateOptionsMenu(menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.action_add:
                Intent i = new Intent(RecommendedActivities.this, AddEditActivity.class );
                startActivity(i);
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
