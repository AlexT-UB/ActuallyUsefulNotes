package com.example.actuallyusefulnotes.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actuallyusefulnotes.ViewModel.AUNViewModel;
import com.example.actuallyusefulnotes.R;
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
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    selectedFragment, "GRUPOS").commit();
                            break;
                        case R.id.nav_notas:
                            selectedFragment = new Fragmento_Notas();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    selectedFragment, "NOTAS").commit();
                            break;
                        case R.id.nav_ajustes:
                            selectedFragment = new Fragmento_Ajustes();
                            getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                                    selectedFragment, "AJUSTES").commit();
                            break;
                    }
                    return true;
                }
            };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        AUNViewModel model = new ViewModelProvider(this).get(AUNViewModel.class);
        main_screen();

    }

    public void main_screen(){
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
            if(getSupportFragmentManager().findFragmentByTag("NOTAS") != null && getSupportFragmentManager().findFragmentByTag("NOTAS").isVisible()){
                Intent i = new Intent(MainActivity.this, AddNote.class);
                startActivity(i);
            } else if(getSupportFragmentManager().findFragmentByTag("GRUPOS") != null && getSupportFragmentManager().findFragmentByTag("GRUPOS").isVisible()){
                Intent i = new Intent(MainActivity.this, AddGroup.class);
                startActivity(i);
            }
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
            System.out.println("THERE");
            Intent i = new Intent(MainActivity.this, AddNote.class);
            startActivity(i);
            Toast.makeText(this, "JAJAJA", Toast.LENGTH_SHORT).show();
        }
        return super.onOptionsItemSelected(item);
        //return false;
    }
}
