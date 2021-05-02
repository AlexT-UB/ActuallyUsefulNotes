package com.example.actuallyusefulnotes.View;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actuallyusefulnotes.R;

public class AddNotaTexto extends AppCompatActivity {

    EditText titulo;
    EditText contenido;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nota_texto);

        titulo = findViewById(R.id.nota_titulo);
        contenido = findViewById(R.id.nota_texto_contenido);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.note_add, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.save_note) {
            saveNote();
        }
        return true;
    }

    private void saveNote() {
        String titulo_nota = titulo.getText().toString();
        String contenido_nota = contenido.getText().toString();

        Intent intent = new Intent();
        intent.putExtra("titulo_nota", titulo_nota);
        intent.putExtra("contenido_nota", contenido_nota);

        int id = getIntent().getIntExtra("id", -1);
        if(id != -1) {
            intent.putExtra("id", id);
        }
        setResult(RESULT_OK, intent);
        finish();
    }
}
