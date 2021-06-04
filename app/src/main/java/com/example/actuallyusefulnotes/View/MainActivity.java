package com.example.actuallyusefulnotes.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;


import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import com.example.actuallyusefulnotes.Model.Group;
import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.ViewModel.AUNViewModel;
import com.example.actuallyusefulnotes.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private AUNViewModel viewModel;
    private RecyclerView recyclerView;

    FirebaseFirestore db;
    FirestoreRecyclerAdapter<Note, noteHolder> adapter;



    BottomNavigationView bottomNavigationView;

    private BottomNavigationView.OnNavigationItemSelectedListener navListener =
            new BottomNavigationView.OnNavigationItemSelectedListener() {
                @Override
                public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                    Fragment selectedFragment = null;
                    switch (item.getItemId()) {
                        case R.id.nav_grupos:
                            onGroup();
                            break;
                        case R.id.nav_notas:
                            onNote();
                            break;
                        case R.id.nav_ajustes:
                            onSettings();
                            break;
                    }
                    return true;
                }
            };


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        System.out.println("EVERYTHING IS FINE");
        super.onCreate(savedInstanceState);
        System.out.println("CREATED MAIN");
        setContentView(R.layout.activity_main);
        System.out.println("IN MAIN");
        onGroup();
        toolBar = findViewById(R.id.topAppBar);
        Button addNote = findViewById(R.id.addNote);

        setSupportActionBar(toolBar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    public void onGroup(){
        ListView simpleList = (ListView) findViewById(R.id.simpleListView);
        simpleList.setVisibility(View.VISIBLE);
        Button addGroup = findViewById(R.id.addNote);
        addGroup.setVisibility(View.VISIBLE);
        addGroup.setOnClickListener((v -> {
            Intent i = new Intent(MainActivity.this, AddGroup.class);
            startActivity(i);
        }));
        ArrayList<Group> groups = getGroups();
        GroupAdapter myAdapter = new GroupAdapter(this, R.layout.group_list, groups);
        simpleList.setAdapter(myAdapter);
        System.out.println(groups.get(0).getTitle());
    }

    public void onNote(){
        ListView simpleList = (ListView) findViewById(R.id.simpleListView);
        simpleList.setVisibility(View.VISIBLE);
        ArrayList<Note> notes = getNotes();
        NoteAdapter myAdapter = new NoteAdapter(this, R.layout.note_list, notes);
        simpleList.setAdapter(myAdapter);
        Button addnote = findViewById(R.id.addNote);
        addnote.setVisibility(View.VISIBLE);
        addnote.setOnClickListener((v -> {
            Intent i = new Intent(MainActivity.this, AddNote.class);
            startActivity(i);
        }));
    }

    public void onSettings(){
        ListView simpleList = (ListView) findViewById(R.id.simpleListView);
        ArrayList<String> SettingList= new ArrayList<>();
        SettingList.add("Modifica Nomre De Usuario");
        SettingList.add("Modifica Contraseña");
        SettingList.add("Traducir al Ingles");
        SettingList.add("Salir");
        SettingsAdapter myAdapter = new SettingsAdapter(this, R.layout.layout_settings, SettingList);
        simpleList.setAdapter(myAdapter);
        simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, final View view,
                                    int position, long id) {
                System.out.println(position);
                Intent i = new Intent(MainActivity.this, Settings.class);
                i.putExtra("Position", position);
                startActivity(i);
            }
        });
        Button addnote = findViewById(R.id.addNote);
        addnote.setVisibility(View.GONE);
    }

    private ArrayList<Note> getNotes() {
        String[] protolist = new String[0];
        ArrayList<Note> groupList = new ArrayList<Note>();
        groupList.add(new Note("First", "A", "12/2/2021", "12:00:00", "First Author", "TEXT HERE", 0));
        groupList.add(new Note("Second", "B", "12/2/2021", "12:00:00", "Second Author", "TEXT HERE", 0));
        groupList.add(new Note("Third", "C", "12/2/2021", "12:00:00", "Third Author", "TEXT HERE", 0));
        groupList.add(new Note("Fourth", "D", "12/2/2021", "12:00:00", "Fourth Author", "TEXT HERE", 0));
        return groupList;
    }

    private ArrayList<Group> getGroups() {
        String[] protolist = new String[0];
        ArrayList<Group> groupList = new ArrayList<Group>();
        groupList.add(new Group("First", "First Title", protolist));
        groupList.add(new Group("Second", "Second Title", protolist));
        groupList.add(new Group("Third", "Third Title", protolist));
        groupList.add(new Group("Fourth", "Fourth Title", protolist));
        return groupList;
    }

    public class noteHolder extends RecyclerView.ViewHolder {
        TextView title;
        View view;

        public noteHolder(@NonNull View itemView) {
            super(itemView);
            title = itemView.findViewById(R.id.textBox_events_verNotas);
            view = itemView;
        }
    }

    protected void onStart() {
        super.onStart();
        System.out.println("EVERYTHING IS FINE");
        db = FirebaseFirestore.getInstance();
        Query query = db.collection("collection");
        AUNViewModel model = new ViewModelProvider(this).get(AUNViewModel.class);
        FirestoreRecyclerOptions<Note> allNotes = new FirestoreRecyclerOptions.Builder<Note>()
                .setQuery(query, Note.class)
                .build();
        adapter = new FirestoreRecyclerAdapter<Note, noteHolder>(allNotes) {
            @NonNull
            @Override
            public noteHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_main, parent, false);
                return new noteHolder(view);
            }

            @Override
            protected void onBindViewHolder(@NonNull noteHolder holder, int position, @NonNull Note model) {
                holder.title.setText(model.getTitulo());
                holder.view.setOnClickListener((v) -> {
                    Intent i = new Intent(v.getContext(), Note.class);
                    v.getContext().startActivity(i);
                });
            }
        };
        getGroups();
        adapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        if (adapter != null)
            adapter.stopListening();
    }
}
