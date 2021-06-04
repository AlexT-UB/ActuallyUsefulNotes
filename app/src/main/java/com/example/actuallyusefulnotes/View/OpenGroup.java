package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import com.example.actuallyusefulnotes.Model.Group;
import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.R;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class OpenGroup extends AppCompatActivity {

    FirebaseFirestore db;
    Group group;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        group = (Group)getIntent().getSerializableExtra("Group");
        setContentView(R.layout.editar_grupo);
        TextView text = findViewById(R.id.editTextGroupName);
        text.setText(group.getTitle());
        FloatingActionButton bt_Ok = findViewById(R.id.fab_Ok_Groups);
        bt_Ok.setOnClickListener((v -> {
            group.setTitle(text.getText().toString());
            DocumentReference documentReference = db.collection("Groups").document(group.getAdminUID() +"_"+ group.getDate_created());
            documentReference.set(group);
            finish();
        }));
        ImageButton bt_delete = findViewById(R.id.button_delete_group);
        bt_delete.setOnClickListener((v -> {
            DocumentReference documentReference = db.collection("Groups").document(group.getAdminUID() +"_"+ group.getDate_created());
            documentReference.delete();
            finish();
        }));
    }
}