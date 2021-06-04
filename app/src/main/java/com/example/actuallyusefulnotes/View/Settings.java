package com.example.actuallyusefulnotes.View;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

public class Settings  extends AppCompatActivity {

    int position;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getIntent().getExtras().getInt("Position");
        System.out.println(position);
        switch(position){
            case 0:
                System.out.println("USERNAME");
                break;
            case 1:
                System.out.println("PASSWORD");
                break;
            case 2:
                System.out.println("LANGAUGE");
                break;
            case 3:
                System.out.println("LOGOUT");
                break;
        }
        finish();
    }
}
