package com.example.actuallyusefulnotes.View;

import android.view.ViewGroup;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.actuallyusefulnotes.Model.Group;
import com.example.actuallyusefulnotes.R;

import java.util.ArrayList;


import android.content.Context;
import android.widget.ArrayAdapter;

public class GroupAdapter extends ArrayAdapter<Group> {

    ArrayList<Group> GroupList = new ArrayList<>();

    public GroupAdapter(Context context, int textViewResourceId, ArrayList<Group> objects) {
        super(context, textViewResourceId, objects);
        GroupList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.group_list, null);
        TextView textTitle = v.findViewById(R.id.TextTitle);
        TextView textAdmin = v.findViewById(R.id.TextAdmin);
        textTitle.setText(GroupList.get(position).getTitle());
        textAdmin.setText(GroupList.get(position).getAdmin());
        return v;

    }

}