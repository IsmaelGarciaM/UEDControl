package com.ismael.uedcontrol;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.ismael.uedcontrol.model.Menu;
import com.ismael.uedcontrol.model.Patient;

public class NavigationDrawerActivity extends AppCompatActivity implements View.OnClickListener {

    Button btnProfile;
    Button btnListPatient;
    Button btnMenu;
    Button btnActivities;
    Button btnRecommendedActivities;
    Button btnChat;
    Button btnPreferences;
    Button btnClose;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navigation_drawer);

        btnProfile = (Button) findViewById(R.id.btnProfile);
        btnListPatient = (Button) findViewById(R.id.btnPatientList);
        btnActivities = (Button) findViewById(R.id.btnActivities);
        btnMenu = (Button) findViewById(R.id.btnMenu);
        btnRecommendedActivities = (Button) findViewById(R.id.btnRecomendedActivities);
        btnChat = (Button) findViewById(R.id.btnChat);
        btnPreferences = (Button) findViewById(R.id.btnPreferences);
        btnClose = (Button) findViewById(R.id.btnClose);
        btnProfile.setOnClickListener(this);
        btnActivities.setOnClickListener(this);
        btnListPatient.setOnClickListener(this);
        btnMenu.setOnClickListener(this);
        btnRecommendedActivities.setOnClickListener(this);
        btnChat.setOnClickListener(this);
        btnPreferences.setOnClickListener(this);
        btnClose.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {

        if(v == btnProfile){
            Intent intent = new Intent(this, ProfileActivity.class);
            startActivity(intent);
        }
        if(v == btnListPatient){
            Intent intent = new Intent(this, PatientListActivity.class);
            startActivity(intent);
        }
        if(v == btnActivities){
            Intent intent = new Intent(this, ShowActivities.class);
            startActivity(intent);
        }
        if(v == btnMenu){
            Intent intent = new Intent(NavigationDrawerActivity.this, MenuActivity.class);
            startActivity(intent);
        }
        if(v == btnRecommendedActivities){
            Intent intent = new Intent(NavigationDrawerActivity.this, RecommendedActivities.class);
            startActivity(intent);
        }
        if(v == btnChat){
            Intent intent = new Intent(NavigationDrawerActivity.this, ContactList.class);
            startActivity(intent);
        }
        if(v == btnPreferences){
            Intent intent = new Intent(NavigationDrawerActivity.this, Preferences.class);
            startActivity(intent);
        }

        if(v == btnClose){
        }
    }
}
