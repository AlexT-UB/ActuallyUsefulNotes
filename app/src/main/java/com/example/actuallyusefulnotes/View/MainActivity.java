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
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private Toolbar toolBar;
    private AUNViewModel viewModel;
    private RecyclerView recyclerView;

    FirebaseFirestore db;
    FirestoreRecyclerAdapter<Note, noteHolder> adapter;
    FirebaseAuth auth;


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

        auth = FirebaseAuth.getInstance();

        setContentView(R.layout.activity_main);
        onGroup();
        toolBar = findViewById(R.id.topAppBar);
        Button addNote = findViewById(R.id.addNote);

        setSupportActionBar(toolBar);

        bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(navListener);
    }

    public void onGroup() {
        System.out.println("GROUPS");
        Button addGroup = findViewById(R.id.addNote);
        addGroup.setVisibility(View.VISIBLE);
        addGroup.setOnClickListener((v -> {
            Intent i = new Intent(MainActivity.this, AddGroup.class);
            startActivity(i);
        }));
        ListView simpleList = (ListView) findViewById(R.id.simpleListView);
        ArrayList<Group> groups = getGroups();
        GroupAdapter myAdapter = new GroupAdapter(this, R.layout.group_list, groups);
        simpleList.setAdapter(myAdapter);
        System.out.println(groups.get(0).getTitle());
    }

    public void onNote() {
        System.out.println("NOTES");
        ListView simpleList = (ListView) findViewById(R.id.simpleListView);
        ArrayList<Note> notes = new ArrayList<>();
        db = FirebaseFirestore.getInstance();
        CollectionReference cr = db.collection("notes");


        cr.get()
                .addOnSuccessListener(new OnSuccessListener<QuerySnapshot>() {
                    @Override
                    public void onSuccess(QuerySnapshot queryDocumentSnapshots) {
                        if (!queryDocumentSnapshots.isEmpty()) {
                            for (QueryDocumentSnapshot note : queryDocumentSnapshots) {
                                Note jobPost = note.toObject(Note.class);
                                notes.add(jobPost);
                            }
                        }
                    }
                })
                .addOnFailureListener(new OnFailureListener() {
                    @Override
                    public void onFailure(@NonNull Exception e) {

                    }
                });


        NoteAdapter myAdapter = new NoteAdapter(this, R.layout.note_list, notes);
        simpleList.setAdapter(myAdapter);
        Button addnote = findViewById(R.id.addNote);
        addnote.setVisibility(View.VISIBLE);
        addnote.setOnClickListener((v -> {
            Intent i = new Intent(MainActivity.this, AddNote.class);
            startActivity(i);
        }));
        Fragment selectedFragment = new Fragmento_Notas();
        /*getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment, "NOTAS").commit();*
        /*
        recyclerView = findViewById(R.id.listaNotas);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);*/
    }

    public void onSettings() {
        System.out.println("SETTINGS");
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
        FirebaseUser user = auth.getCurrentUser();
        if (user == null)
            signUp();
        db = FirebaseFirestore.getInstance();
        Query query = db.collection("notes").orderBy("title", Query.Direction.DESCENDING);
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

    protected void signUp() {
        Intent i = new Intent(MainActivity.this, Start_Up.class);
    }

    protected void onStop() {
        super.onStop();
        if (adapter != null)
            adapter.stopListening();
    }
}
