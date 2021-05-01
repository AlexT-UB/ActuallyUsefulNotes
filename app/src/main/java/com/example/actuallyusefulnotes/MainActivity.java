package com.example.actuallyusefulnotes;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModel;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private AUNViewModel viewModel;
    private RecyclerView recyclerView;

    BottomNavigationView bottomNavigationView;
    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;

                    switch (item.getItemId()) {
                        case R.id.nav_grupos:
                            selectedFragment = new Fragmento_Grupos();
                            break;
                        case R.id.nav_notas:
                            selectedFragment = new Fragmento_Notas();
                            break;
                        case R.id.nav_ajustes:
                            selectedFragment = new Fragmento_Ajustes();
                            break;
                    }
                    getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                            selectedFragment).commit();
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AUNViewModel model = new ViewModelProvider(this).get(AUNViewModel.class);
        setContentView(R.layout.signin);

        Button bt_signin = findViewById(R.id.bt_signin);
        Button login = findViewById(R.id.bt_login);
        Button go_login = findViewById(R.id.bt_lay_login);
        Button go_signin = findViewById(R.id.bt_lay_signin);


        bt_signin.setOnClickListener((v -> {

            help();
        }));

        go_login.setOnClickListener((v -> {

            setContentView(R.layout.login);
        }));


    }


    public void help(){
        System.out.println("Still working on it");
        setContentView(R.layout.activity_main);

        toolBar = findViewById(R.id.topAppBar);
        recyclerView = findViewById(R.id.listaNotas);
        Button addNote = findViewById(R.id.addNote);

        setSupportActionBar(toolBar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);

        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                new Fragmento_Notas()).commit();

        addNote.setOnClickListener((v -> {

           
        }));
    }


    public boolean onCreateOptionMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main_menu, menu);
        //super.onCreateOptionsMenu(menu);
        //getMenuInflater().inflate(R.menu.main_menu, menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.addNote) {
            Intent i = new Intent(this, AddNote.class);
            startActivity(i);
            Toast.makeText(this, "JAJAJA", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
    }
}
