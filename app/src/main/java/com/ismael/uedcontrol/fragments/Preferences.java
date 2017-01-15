package com.ismael.uedcontrol.fragments;

import android.app.Activity;
import android.os.Bundle;
import android.preference.PreferenceFragment;

import com.ismael.uedcontrol.R;

/**
 * Created by ismael on 13/01/17.
 */

public class Preferences extends PreferenceFragment {

    IClear callback;
    public static PreferenceFragment getInstance(){
        Preferences f = new Preferences();
        return f;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        // Load the preferences from an XML resource
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        callback.limpiar();
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        callback = (IClear)activity;
    }

    public interface IClear{
        void limpiar();
    }


}
