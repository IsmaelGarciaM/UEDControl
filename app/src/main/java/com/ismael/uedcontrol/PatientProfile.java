package com.ismael.uedcontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Date;

public class PatientProfile extends AppCompatActivity {


    TextView n;
    TextView sn;
    TextView _dni;
    ImageView _img;
    TextView date;

    Button btnNewContact;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_patient_profile);

        n = (TextView) findViewById(R.id.txvPatientName);
        sn = (TextView) findViewById(R.id.txvPatientSurname);
        _dni = (TextView) findViewById(R.id.txvPatientDni);
        _img = (ImageView) findViewById(R.id.imgPatient);
        date = (TextView) findViewById(R.id.txvPatientBirthDate);
        btnNewContact = (Button) findViewById(R.id.btnAddContactProfile);

        n.setText(this.getIntent().getStringExtra("name"));
        sn.setText(this.getIntent().getStringExtra("surname"));
        _dni.setText(this.getIntent().getStringExtra("dni"));
        date.setText(this.getIntent().getStringExtra("bdate"));
        _img.setImageResource(this.getIntent().getIntExtra("img", 0));

        btnNewContact.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PatientProfile.this, AddEditContact.class);
                startActivity(i);
            }
        });

    }
}
