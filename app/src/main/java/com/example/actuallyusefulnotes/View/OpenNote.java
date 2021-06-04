package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class OpenNote extends AppCompatActivity {

    FirebaseFirestore db;
    Note note;
    String UID;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        note = (Note)getIntent().getSerializableExtra("Note");
        UID = getIntent().getStringExtra("UID");
        setContentView(R.layout.editar_nota);
        TextView title = findViewById(R.id.title);
        title.setText(note.getTitulo());
        TextView text = findViewById(R.id.text_Contenido);
        text.setText(note.getText());
        FloatingActionButton bt_Ok = findViewById(R.id.bt_Ok);
        TextView finalTitle = title;
        TextView finalText = text;
        bt_Ok.setOnClickListener((v -> {
            note.setTitulo(title.getText().toString());
            note.setText(text.getText().toString());
            DocumentReference documentReference = db.collection("notes").document(UID).collection("myNotes").document(UID+"_"+ note.getDate());
            documentReference.set(note);
            finish();
        }));
    }
}