package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.actuallyusefulnotes.Model.Group;
import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddGroup extends AppCompatActivity {
    FirebaseFirestore db;
    private EditText groupTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("GROOOOOOOOOOOOOOOOOUP");
        super.onCreate(savedInstanceState);
        FloatingActionButton bt_Ok = findViewById(R.id.bt_Ok);
        db = FirebaseFirestore.getInstance();

        setContentView(R.layout.editar_group);

        groupTitle = findViewById(R.id.text);


        FloatingActionButton save = findViewById(R.id.bt_Ok2);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (groupTitle.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "El titulo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    return;
                }

                String[] protolist = {"Alex"};

                final Group group = new Group("alex", protolist, groupTitle.getText().toString());

                group.setTitle(groupTitle.getText().toString());

                DocumentReference documentReference = db.collection("groups").document();

                documentReference.set(group);
                Toast.makeText(AddGroup.this, "Guardado", Toast.LENGTH_SHORT).show();
                return;
            }
        });
    }
}