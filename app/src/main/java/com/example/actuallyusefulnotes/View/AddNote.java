package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.actuallyusefulnotes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddNote extends AppCompatActivity {
    FloatingActionButton floatingActionButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        floatingActionButton = findViewById(R.id.addNote);

        floatingActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent opciones = new Intent(AddNote.this, ElegirTipoNota.class);
                startActivity(opciones);
            }
        });

    }
}
