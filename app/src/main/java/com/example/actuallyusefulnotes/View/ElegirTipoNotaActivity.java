package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.actuallyusefulnotes.R;

public class ElegirTipoNotaActivity extends AppCompatActivity {

    Button texto;
    Button audio;
    Button imagen;
    Button calendario;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_nota);

        /*texto = findViewById(R.id.NotaTexto);
        audio = findViewById(R.id.NotaAudio);
        imagen = findViewById(R.id.NotaFoto);
        calendario = findViewById(R.id.NotaCalendario);

        texto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notaTexto = new Intent(ElegirTipoNotaActivity.this, AddNotaTextoActivity.class);
            }
        });

        audio.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notaAudio = new Intent(ElegirTipoNotaActivity.this, AddNotaAudioActivity.class);
            }
        });

        imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent notaImagen = new Intent(ElegirTipoNotaActivity.this, AddNotaImagenActivity.class);
            }
        });

        calendario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });*/
    }
}