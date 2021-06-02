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
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        System.out.println("GROUPS");
        ListView simpleList = (ListView) findViewById(R.id.simpleListView);
        String[] protolist = new String[0];
        ArrayList<Group> example = new ArrayList<Group>();
        example.add(new Group("First", "First Title", protolist));
        example.add(new Group("Second", "Second Title", protolist));
        example.add(new Group("Third", "Third Title", protolist));
        example.add(new Group("Fourth", "Fourth Title", protolist));
        GroupAdapter myAdapter = new GroupAdapter(this,R.layout.group_list,example);
        simpleList.setAdapter(myAdapter);
        System.out.println(example.get(0).getTitle());

    }

    public void onGroup(){
        System.out.println("GROUPS");
        ListView simpleList = (ListView) findViewById(R.id.simpleListView);
        String[] protolist = new String[0];
        ArrayList<Group> example = new ArrayList<Group>();
        example.add(new Group("First", "First Title", protolist));
        example.add(new Group("Second", "Second Title", protolist));
        example.add(new Group("Third", "Third Title", protolist));
        example.add(new Group("Fourth", "Fourth Title", protolist));
        GroupAdapter myAdapter = new GroupAdapter(this,R.layout.group_list,example);
        simpleList.setAdapter(myAdapter);
        System.out.println(example.get(0).getTitle());
        Button addGroup = findViewById(R.id.addNote);
        addGroup.setOnClickListener((v -> {
            Intent i = new Intent(MainActivity.this, AddGroup.class);
            startActivity(i);
        }));
    }

    public void onNote(){

        System.out.println("NOTES");
        Button addNote = findViewById(R.id.addNote);
        addNote.setOnClickListener((v -> {
            Intent i = new Intent(MainActivity.this, AddNote.class);
            startActivity(i);
        }));

        Fragment selectedFragment = new Fragmento_Notas();
        getSupportFragmentManager().beginTransaction().replace(R.id.fragment_container,
                selectedFragment, "NOTAS").commit();
        db = FirebaseFirestore.getInstance();
        Query query = db.collection("collection");
        AUNViewModel model = new ViewModelProvider(this).get(AUNViewModel.class);
        getNotes();
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
                holder.view.setOnClickListener((v) ->{
                    Intent i = new Intent(v.getContext(), Note.class);
                    v.getContext().startActivity(i);
                } );
            }
        };
        recyclerView = findViewById(R.id.listaNotas);
        recyclerView.setLayoutManager(new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL));
        recyclerView.setAdapter(adapter);
    }

    public void onSettings(){

    }

    private void getNotes() {

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
        onNote();
        adapter.startListening();
    }

    protected void onStop() {
        super.onStop();
        if (adapter != null)
            adapter.stopListening();
    }
}
