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
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class AddGroup extends AppCompatActivity {
    FirebaseFirestore db;
    FirebaseUser user;
    private EditText groupTitle;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.editar_grupo);

        db = FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();

        groupTitle = findViewById(R.id.editTextGroupName);


        FloatingActionButton save = findViewById(R.id.fab_Ok_Groups);
        save.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                if (groupTitle.getText().toString().isEmpty()) {
                    Toast.makeText(getApplicationContext(), "El titulo no puede estar vacío", Toast.LENGTH_SHORT).show();
                    return;
                }

                final Group group = new Group();

                group.setTitle(groupTitle.getText().toString());
                group.setAdmin(user.getDisplayName());

                DocumentReference documentReference = db.collection("Groups").document();

                documentReference.set(group);
                Toast.makeText(AddGroup.this, "Guardado", Toast.LENGTH_SHORT).show();
                finish();
            }
        });
    }
}