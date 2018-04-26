package com.example.clayou.addressbook;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

/**
 * Created by 10295 on 2018/4/4.
 */

public class ContactsAdapter extends ArrayAdapter {

    private int resourceId;

    public ContactsAdapter(Context context, int textViewResourceId, List<Contacts> objects){
        super(context, textViewResourceId, objects);
        resourceId = textViewResourceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        Contacts contacts = (Contacts) getItem(position);

        View view;
        if(convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId, parent, false);
        }else{
            view = convertView;
        }

        ImageView contactsAvatar = view.findViewById(R.id.img);
        TextView contactsName = view.findViewById(R.id.textView);

        contactsAvatar.setImageResource(contacts.getAvatarId());
        contactsName.setText(contacts.getName());

        return view;
    }
}
