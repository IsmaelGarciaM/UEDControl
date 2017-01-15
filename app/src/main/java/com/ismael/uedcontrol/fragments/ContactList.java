package com.ismael.uedcontrol.fragments;


import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.adapter.ContactAdapter;
import com.ismael.uedcontrol.model.Contact;

import java.util.Comparator;

/**
 * A simple {@link Fragment} subclass.
 */
public class ContactList extends Fragment {

    private ContactAdapter adapter;
    private ListView clist;
    IChatListener mCallback;


    public interface IChatListener{
        void startChat();
    }
    public ContactList() {
        // Required empty public constructor
    }

    public static ContactList getInstance(Bundle b){
        ContactList f = new ContactList();
        f.setArguments(b);
        return f;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View rootV = inflater.inflate(R.layout.fragment_contact_list, container, false);
        adapter = new ContactAdapter(this.getContext());
        clist = (ListView) rootV.findViewById(R.id.listContacts);
        clist.setAdapter(adapter);

        clist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //Intent i = new Intent(ContactList.this, ChatActivity.class);
                //startActivity(i);
            }
        });
        return rootV;
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        mCallback = (IChatListener)activity;
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        inflater.inflate(R.menu.menu_contact, menu);
        super.onCreateOptionsMenu(menu, inflater);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){

            case R.id.action_sort_alphabetically:
                adapter.sort(new Comparator<Contact>() {
                    @Override
                    public int compare(Contact o1, Contact o2) {
                        return o1.compareTo(o2);
                    }
                });
                break;

        }
        return super.onOptionsItemSelected(item);
    }

}
