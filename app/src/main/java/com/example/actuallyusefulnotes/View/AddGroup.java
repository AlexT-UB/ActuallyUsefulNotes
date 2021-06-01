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
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_group);
        FloatingActionButton bt_Ok = findViewById(R.id.bt_Ok);
        bt_Ok.setOnClickListener((v -> {
            System.out.println("WE ARE HERE");
            Intent intent = new Intent(AddGroup.this, MainActivity.class);
            startActivity(intent);
        }));
    }
}