package com.example.actuallyusefulnotes.View;

import android.content.Intent;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.ViewHolder;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.TextView;

import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.R;

import java.util.ArrayList;
import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolder> {

    List<String> titles;
    private onItemClickListner listner;

    public NoteAdapter(List<String> title){
        titles = title;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.add_nota_texto, viewGroup, false);
        return new ViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        viewHolder.title.setText(titles.get(i));
        viewHolder.view.setOnClickListener((v) ->{
            Intent in = new Intent(v.getContext(), Note.class);
            v.getContext().startActivity(in);
        } );
    }

    @Override
    public int getItemCount() {
        return titles.size();
    }

    public void setTitle(List<String> title) {
        this.titles = title;
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        TextView title;
        View view;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.nota_titulo);
            view = itemView;
        }

        public void bind(int position) {
            title.setText(titles.get(position));
        }
    }

    public String getTitleAt(int position) {
        return titles.get(position);
    }

    public interface onItemClickListner {
        void onItemClick(String string);
    }

    public void setOnItemClickListner(onItemClickListner listner) {
        this.listner = listner;
    }
}
