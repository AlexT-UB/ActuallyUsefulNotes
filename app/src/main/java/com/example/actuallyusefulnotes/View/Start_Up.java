package com.example.actuallyusefulnotes.View;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actuallyusefulnotes.ViewModel.AUNViewModel;
import com.example.actuallyusefulnotes.R;

public class Start_Up extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AUNViewModel model = new ViewModelProvider(this).get(AUNViewModel.class);
        sign_up();

    }

    public void sign_up() {
        setContentView(R.layout.signin);

        Button bt_signin = findViewById(R.id.bt_signin);
        Button go_login = findViewById(R.id.bt_lay_login);


        bt_signin.setOnClickListener((v -> {
            Intent intent = new Intent(Start_Up.this, MainActivity.class);
            startActivity(intent);
        }));

        go_login.setOnClickListener((v -> {

            log_in();
        }));
    }

    public void log_in() {
        setContentView(R.layout.login);

        Button bt_login = findViewById(R.id.bt_login);
        Button go_signup = findViewById(R.id.bt_lay_signup);

        bt_login.setOnClickListener((v -> {
            Intent intent = new Intent(Start_Up.this, MainActivity.class);
            startActivity(intent);
        }));

        go_signup.setOnClickListener((v -> {

            sign_up();
        }));
    }
}