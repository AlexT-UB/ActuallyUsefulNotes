package com.example.actuallyusefulnotes;

import android.content.Context;
import android.os.AsyncTask;
import android.text.NoCopySpan;

import androidx.annotation.NonNull;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

public abstract class NoteDataBase extends RoomDatabase {

    public abstract NoteDAO noteDAO();
    private static NoteDataBase instance;

    public static synchronized NoteDataBase getInstance (Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context, NoteDataBase.class, "NoteDataBase")
                    .fallbackToDestructiveMigration().addCallback(roomCallback).build();
        }
        return instance;
    }

    private static RoomDatabase.Callback roomCallback = new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void> {
        private NoteDAO noteDAO;
        private PopulateDbAsyncTask(NoteDataBase noteDatabase){
            this.noteDAO = noteDatabase.noteDAO();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            return null;
        }
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return null;
    }

    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return null;
    }

    @Override
    public void clearAllTables() {

    }
}
