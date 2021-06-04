package com.example.actuallyusefulnotes.View;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.example.actuallyusefulnotes.R;
import com.google.common.base.CharMatcher;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.auth.UserProfileChangeRequest;
import com.google.firebase.firestore.FirebaseFirestore;

public class Settings  extends AppCompatActivity {
    FirebaseFirestore db;
    FirebaseUser user;
    FirebaseAuth auth;
    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        db = FirebaseFirestore.getInstance();
        user = FirebaseAuth.getInstance().getCurrentUser();
        position = getIntent().getExtras().getInt("Position");
        switch(position){
            case 0:
                changeUsername();
                break;
            case 1:
                changePassword();
                break;
            case 2:
                changeLanguage();
                break;
            case 3:
                logout();
                break;
        }
        finish();
    }

    private void changeUsername() {
        AlertDialog.Builder alert = new AlertDialog.Builder(this);

        alert.setTitle("Title");
        alert.setMessage("Message");
        final EditText input = new EditText(this);
        alert.setView(input);

        alert.setPositiveButton("Ok", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {

                // Do something with value!
            }
        });

        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            public void onClick(DialogInterface dialog, int whichButton) {
                // Canceled.
            }
        });

        alert.show();
        /*FirebaseUser user = auth.getCurrentUser();
        UserProfileChangeRequest name = new UserProfileChangeRequest.Builder()
                .setDisplayName(username).build();
        user.updateProfile(name);*/
    }

    private void changePassword() {
    }

    private void changeLanguage() {
        findViewById(R.id.title);
    }

    private void logout(){
        Intent intent = new Intent(this, Start_Up.class);
        this.startActivity(intent);
        this.finishAffinity();
    }
}
