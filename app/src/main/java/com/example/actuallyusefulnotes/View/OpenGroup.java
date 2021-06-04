package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import com.example.actuallyusefulnotes.Model.Group;
import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class OpenGroup extends AppCompatActivity {

    Group group;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        group = (Group)getIntent().getSerializableExtra("Group");
        setContentView(R.layout.editar_grupo);
        TextView text = findViewById(R.id.editTextGroupName);
        text.setText(group.getTitle());
        FloatingActionButton bt_Ok = findViewById(R.id.fab_Ok_Groups);
        bt_Ok.setOnClickListener((v -> {
            finish();
        }));
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