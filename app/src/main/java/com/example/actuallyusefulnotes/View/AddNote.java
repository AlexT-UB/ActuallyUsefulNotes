package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.AsyncTask;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

import java.util.Calendar;

public class AddNote extends AppCompatActivity {
    FirebaseFirestore db;
    FirebaseUser user;
    private EditText noteTitle, noteText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        setContentView(R.layout.editar_nota);

        noteTitle = findViewById(R.id.title);
        noteText = findViewById(R.id.text_Contenido);


        FloatingActionButton save = findViewById(R.id.bt_Ok);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (noteTitle.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "El titulo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    return;
                }

                final Note note = new Note();

                note.setTitulo(noteTitle.getText().toString());
                note.setText(noteText.getText().toString());
                note.setDate(Calendar.getInstance().getTime().toString());
                DocumentReference documentReference = db.collection("notes").document(user.getUid()).collection("myNotes").document(user.getUid()+"_"+ note.getDate());
                documentReference.set(note);
                Toast.makeText(AddNote.this, "Guardado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}

