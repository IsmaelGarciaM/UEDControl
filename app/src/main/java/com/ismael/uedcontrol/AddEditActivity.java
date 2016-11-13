package com.ismael.uedcontrol;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;

import com.ismael.uedcontrol.adapter.PatientAdapter;

import java.util.Date;

public class AddEditActivity extends Activity {

    Button btnDateActivity;
    PatientAdapter adapter;
    ListView listPatientForActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_activity);

        listPatientForActivity = (ListView) findViewById(R.id.listPatient) ;
        adapter = new PatientAdapter(this);
        listPatientForActivity.setAdapter(adapter);
        btnDateActivity = (Button) findViewById(R.id.btnDateActivity);
        btnDateActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(0);
            }
        });
    }

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == 0) {
            Date d = new Date();
            d.setTime(d.getTime());
            return new DatePickerDialog(this, myDateListener, d.getYear(), d.getMonth(), d.getDay());
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener myDateListener = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker arg0, int arg1, int arg2, int arg3) {
        }

    };
}
