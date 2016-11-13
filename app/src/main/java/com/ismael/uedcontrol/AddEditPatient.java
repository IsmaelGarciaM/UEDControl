package com.ismael.uedcontrol;

import android.app.DatePickerDialog;
import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;

import java.util.Date;

public class AddEditPatient extends AppCompatActivity {

    Button btnAddContact;
    Button btnBdatePicker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_edit_patient);
        btnAddContact = (Button) findViewById(R.id.btnAddContact);
        btnAddContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AddEditPatient.this, AddEditContact.class);
                startActivity(i);
            }
        });

        btnBdatePicker = (Button) findViewById(R.id.btnBirthdatePicker);
        btnBdatePicker.setOnClickListener(new View.OnClickListener() {
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
