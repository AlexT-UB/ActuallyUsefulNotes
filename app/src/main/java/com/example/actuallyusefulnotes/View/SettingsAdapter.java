package com.example.actuallyusefulnotes.View;

import android.view.ViewGroup;

import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.actuallyusefulnotes.Model.Group;
import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.R;

import java.util.ArrayList;


import android.content.Context;
import android.widget.ArrayAdapter;

public class SettingsAdapter extends ArrayAdapter<String> {

    ArrayList<String> SettingsList;

    public SettingsAdapter(Context context, int textViewResourceId, ArrayList<String> object) {
        super(context, textViewResourceId, object);
        SettingsList = object;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.layout_settings, null);
        TextView textSettings = v.findViewById(R.id.txt_settings);
        textSettings.setText(SettingsList.get(position));
        return v;
    }
}