package com.example.actuallyusefulnotes.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;


import androidx.fragment.app.Fragment;
import androidx.appcompat.widget.Toolbar;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.RecyclerView;

import com.example.actuallyusefulnotes.Model.Group;
import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.ViewModel.AUNViewModel;
import com.example.actuallyusefulnotes.R;
import com.firebase.ui.firestore.FirestoreRecyclerAdapter;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.net.ConnectException;
import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private AUNViewModel viewModel;
    private RecyclerView recyclerView;

    FirebaseFirestore db;



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
        super.onCreate(savedInstanceState);
        System.out.println("ONCREATE");
        setContentView(R.layout.activity_main);
        toolBar = findViewById(R.id.topAppBar);
        Button addNote = findViewById(R.id.addNote);

        setSupportActionBar(toolBar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    public void onGroup(){
        Context con = this;
        displayGroups(con);
    }

    public void onNote(){
        Context con = this;
        displayNotes(con);
    }

    public void onSettings(){
        System.out.println("SETTINGS");
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
                Intent i = new Intent(MainActivity.this, Settings.class);
                i.putExtra("Position", position);
                startActivity(i);
            }
        });
        Button addnote = findViewById(R.id.addNote);
        addnote.setVisibility(View.GONE);
    }

    private void displayGroups(Context con) {
        ArrayList<Group> groupList = new ArrayList<Group>();
        CollectionReference collectionReference = db.collection("Groups");

        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()){
                    for(QueryDocumentSnapshot groups: queryDocumentSnapshots){
                        Group group = groups.toObject(Group.class);
                        System.out.println(groups.toObject(Group.class).getTitle());
                        groupList.add(group);
                    }
                    System.out.println(groupList.get(0).getTitle());
                }
                System.out.println("ON TOP");
                ListView simpleList = (ListView) findViewById(R.id.simpleListView);
                simpleList.setVisibility(View.VISIBLE);
                GroupAdapter myAdapter = new GroupAdapter(con, R.layout.group_list, groupList);
                simpleList.setAdapter(myAdapter);
                Button addGroup = findViewById(R.id.addNote);
                addGroup.setVisibility(View.VISIBLE);
                addGroup.setOnClickListener((v -> {
                    Intent i = new Intent(MainActivity.this, AddGroup.class);
                    startActivity(i);
                }));
            }
        });
    }

    private void displayNotes(Context con) {
        ArrayList<Note> noteList = new ArrayList<Note>();
        CollectionReference collectionReference = db.collection("notes");
        collectionReference.get().addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
            @Override
            public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                if (!queryDocumentSnapshots.isEmpty()){
                    for(QueryDocumentSnapshot notes: queryDocumentSnapshots){
                        Note note = notes.toObject(Note.class);
                        System.out.println("Titulo de la nota Firebase" + note.getTitulo());
                        noteList.add(note);
                    }
                }
                ListView simpleList = (ListView) findViewById(R.id.simpleListView);
                simpleList.setVisibility(View.VISIBLE);
                NoteAdapter myAdapter = new NoteAdapter(con, R.layout.note_list, noteList);
                simpleList.setAdapter(myAdapter);
                Button addnote = findViewById(R.id.addNote);
                addnote.setVisibility(View.VISIBLE);
                addnote.setOnClickListener((v -> {
                    Intent i = new Intent(MainActivity.this, AddNote.class);
                    startActivity(i);
                }));
                simpleList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, final View view,
                                            int position, long id) {
                        Intent i = new Intent(MainActivity.this, OpenNote.class);
                        i.putExtra("Note", noteList.get(position));
                        startActivity(i);
                        onNote();
                    }

                });
            }
        });
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
        db = FirebaseFirestore.getInstance();
        Query query = db.collection("collection");
        AUNViewModel model = new ViewModelProvider(this).get(AUNViewModel.class);
        /*FirestoreRecyclerOptions<Note> allNotes = new FirestoreRecyclerOptions.Builder<Note>()
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
        };*/
        Context con = this;
        displayGroups(con);
        //adapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        /*if (adapter != null)
            adapter.stopListening();*/
    }


}
