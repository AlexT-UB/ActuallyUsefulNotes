package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.actuallyusefulnotes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class AddGroup extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("WE ARE HERE 1");
        super.onCreate(savedInstanceState);
        System.out.println("WE ARE HERE 2");
        setContentView(R.layout.editar_grupo);
        System.out.println("WE ARE HERE 3");
        FloatingActionButton bt_Ok = findViewById(R.id.fab_Ok_Groups);
        System.out.println("WE ARE HERE 4");
        bt_Ok.setOnClickListener((v -> {
            System.out.println("WE ARE HERE");
            Intent intent = new Intent(AddGroup.this, MainActivity.class);
            startActivity(intent);
        }));
    }
}