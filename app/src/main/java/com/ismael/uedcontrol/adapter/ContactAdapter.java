package com.ismael.uedcontrol.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import com.ismael.uedcontrol.R;
import com.ismael.uedcontrol.model.Contact;
import com.ismael.uedcontrol.repositories.ContactRepository;


public class ContactAdapter extends ArrayAdapter<Contact> {

    public ContactAdapter(Context context) {
        super(context, R.layout.item_patient, ContactRepository.getInstance().subList(0, ContactRepository.getInstance().size()));
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View item = convertView;
        ContactHolder ch ;

        if(item == null) {
            LayoutInflater ltInflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            item = ltInflater.inflate(R.layout.item_chat, null);
            ch = new ContactHolder();
            ch.txvName = (TextView) item.findViewById(R.id.txvNameContact);
            item.setTag(ch);
        }
        else
            ch = (ContactHolder) item.getTag();

        ch.txvName.setText(getItem(position).toString());

        return item;

    }

    class ContactHolder{
        TextView txvName;
    }
}


