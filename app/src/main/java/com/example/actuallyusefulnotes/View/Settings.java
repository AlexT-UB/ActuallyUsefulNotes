package com.example.actuallyusefulnotes.View;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import com.example.actuallyusefulnotes.R;
import com.google.common.base.CharMatcher;

public class Settings  extends AppCompatActivity {

    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
