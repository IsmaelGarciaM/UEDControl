package com.ismael.uedcontrol;

import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.ismael.uedcontrol.fragments.*;
import com.ismael.uedcontrol.fragments.Preferences;

public class HomeActivity extends AppCompatActivity implements Preferences.IClear, ContactList.IChatListener, Recomm_Activities.IRecActivitiesListener, ShowFood.IAddMenuListener, AddEditPatient.IAddContactListener, PatientList.IListPatientListener, PatientProfile.IPatientProfileListener, ShowActivities.IListActivitiesListener {

    PatientList listadoPacientes;
    PatientProfile perfilPaciente;
    AddEditPatient anadirPaciente;
    ShowActivities showActivities;
    AddEditActivitys anadirActividad;
    AddEditContact anadirContacto;
    ContactList listaContactos;
    Recomm_Activities recAct;
    ShowFood mostrarMenu;
    AddEditFood anadirComida;
    android.app.Fragment prefs;

    private long mBackPressed = 0;
    private static final long MAX_TIME = 2500;
    private Toolbar mToolbar;
    private android.support.v4.widget.DrawerLayout mDrawerLayout;
    private NavigationView mNavigationView;
    private ActionBarDrawerToggle mActionBarDrawerToggle;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_navigation);
        mToolbar = (Toolbar)findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.ic_menu);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        mDrawerLayout = (DrawerLayout)findViewById(R.id.drawer_layout);

        mNavigationView = (NavigationView)findViewById(R.id.navigation_view);
        mActionBarDrawerToggle = setupDrawerToggle();
        setupDrawerContent();
        mDrawerLayout.addDrawerListener(mActionBarDrawerToggle);
        setTitle("Listado de pacientes");

        if(savedInstanceState==null) {
            listadoPacientes = PatientList.getInstance(null);
            FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
            fr.add(R.id.frlHome, listadoPacientes);
            fr.addToBackStack("patlist");
            fr.commit();
        }

    }

    @Override
    public void onBackPressed() {

        if(mDrawerLayout.isDrawerOpen(GravityCompat.START)){
            mDrawerLayout.closeDrawer(GravityCompat.START);
        }

        else if (mBackPressed + MAX_TIME > System.currentTimeMillis() || getSupportFragmentManager().getBackStackEntryCount() > 0) {
            super.onBackPressed();
            return;
        } else {
            Snackbar.make(getCurrentFocus(), "Press back again to exit", Snackbar.LENGTH_SHORT).show();
        }
        mBackPressed = System.currentTimeMillis();
    }

    private ActionBarDrawerToggle setupDrawerToggle() {
        return new ActionBarDrawerToggle(this, mDrawerLayout, mToolbar, R.string.drawer_open,  R.string.drawer_close);

    }


    public void showPatients(){
        listadoPacientes = PatientList.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, listadoPacientes);
        fr.addToBackStack("patlist");
        fr.commit();
    }

    @Override
    public void showPatientProfile(Bundle patient) {
        perfilPaciente = PatientProfile.getInstance(patient);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, perfilPaciente);
        fr.addToBackStack("patprof");
        setTitle("Perfil");
        fr.commit();
    }

    @Override
    public void showActivities() {
        showActivities = ShowActivities.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, showActivities);
        fr.addToBackStack("actlist");
        fr.commit();
    }

    @Override
    public void addActivity() {
        anadirActividad = AddEditActivitys.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, anadirActividad);
        fr.addToBackStack("addAct");
        fr.commit();
    }

    @Override
    public void addPatient() {
        anadirPaciente = AddEditPatient.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, anadirPaciente);
        fr.addToBackStack("patadd");
        fr.commit();
    }

    public void showRecAct() {
        recAct = Recomm_Activities.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, recAct);
        fr.addToBackStack("recact");
        fr.commit();
    }


    public void showContactList() {
        listaContactos = ContactList.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, listaContactos);
        fr.addToBackStack("showConList");
        fr.commit();
    }

    @Override
    public void addContact() {
        anadirContacto = AddEditContact.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, anadirContacto);
        fr.addToBackStack("conadd");
        fr.commit();
    }

    public void showFood() {
        mostrarMenu = ShowFood.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, mostrarMenu);
        fr.addToBackStack("showfood");
        fr.commit();
    }


    @Override
    public void addMenu() {
        anadirComida = AddEditFood.getInstance(null);
        FragmentTransaction fr = getSupportFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, anadirComida);
        fr.addToBackStack("foodadd");
        fr.commit();
    }
    private void setupDrawerContent() {
        mNavigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                item.setChecked(true);
                switch (item.getItemId()) {
                    case R.id.action_home:
                        showPatients();
                        break;
                    case R.id.action_act:
                        showActivities();
                        break;
                    case R.id.action_food:
                        showFood();
                        break;
                    case R.id.action_recAct:
                        showRecAct();
                        break;
                    case R.id.action_chat:
                        showContactList();
                        break;
                    case R.id.action_settings:
                        showPrefs();
                        break;
                    case R.id.action_close:
                        finish();
                        break;
                    default:
                        item.setChecked(false);
                        break;
                }
                setTitle(item.getTitle());
                mDrawerLayout.closeDrawer(GravityCompat.START);
                return true;
            }
        });
    }

    @Override
    public void startChat() {

    }

    void showPrefs(){

        prefs = new Preferences();
        android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.replace(R.id.frlHome, prefs);
        getSupportFragmentManager().beginTransaction().replace(R.id.frlHome, new Fragment()).commit();
        fr.addToBackStack("prefs");
        fr.commit();

    }


    public void changeTitle(String tit){
        setTitle(tit);
    }


    @Override
    public void limpiar() {
        android.app.FragmentTransaction fr = getFragmentManager().beginTransaction();
        fr.remove(prefs);
        fr.commit();
    }
}
