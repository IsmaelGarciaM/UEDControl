package com.ismael.uedcontrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;

import com.ismael.uedcontrol.adapter.ActAdapter;
import com.ismael.uedcontrol.model.Activitys;

import java.util.Comparator;

public class ShowActivities extends AppCompatActivity {

    ActAdapter adapter;
    RecyclerView activities;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_activities);
        activities = (RecyclerView) findViewById(R.id.ActRecycler);
        activities.setLayoutManager(new LinearLayoutManager(this));

        adapter = new ActAdapter();
        activities.setAdapter(adapter);
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
                Intent i = new Intent(ShowActivities.this, AddEditActivity.class );
                startActivity(i);
                break;

            case R.id.action_sort_alphabetically:
                adapter.getActivitiesOrder();
                break;

        }
        return super.onOptionsItemSelected(item);
    }
}
