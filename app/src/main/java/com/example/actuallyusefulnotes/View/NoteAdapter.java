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

public class NoteAdapter extends ArrayAdapter<Note> {

    ArrayList<Note> NoteList = new ArrayList<>();

    public NoteAdapter(Context context, int textViewResourceId, ArrayList<Note> objects) {
        super(context, textViewResourceId, objects);
        NoteList = objects;
    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        View v = convertView;
        LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        v = inflater.inflate(R.layout.note_list, null);
        TextView textTitle = v.findViewById(R.id.title_note);
        TextView textAdmin = v.findViewById(R.id.date_note);
        textTitle.setText(NoteList.get(position).getTitulo());
        textAdmin.setText(NoteList.get(position).getDate());
        return v;

    }
}

