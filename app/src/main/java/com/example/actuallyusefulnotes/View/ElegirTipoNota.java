package com.example.actuallyusefulnotes.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actuallyusefulnotes.R;

public class ElegirTipoNota extends AppCompatActivity {

    Button texto;
    Button audio;
    Button imagen;
    Button calendario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        texto = findViewById(R.id.NotaTexto);
        audio = findViewById(R.id.NotaAudio);
        imagen = findViewById(R.id.NotaFoto);
        calendario = findViewById(R.id.NotaCalendario);

        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notaTexto = new Intent(ElegirTipoNota.this, AddNotaTexto.class);
            }
        });

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }
}
