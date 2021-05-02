package com.example.actuallyusefulnotes;

import android.app.Application;
import android.os.AsyncTask;
import android.provider.ContactsContract;

import androidx.lifecycle.LiveData;

import java.util.List;

public class NoteRepository {

    private NoteDAO noteDao;
    private LiveData<List<Note>> allNotes;

    public NoteRepository(Application application) {

    }

    public void insert(Note note) {
        new InsertAsyncTask(noteDao).execute(note);
    }

    public void update(Note note) {
        new UpdateAsysncTask(noteDao).execute(note);
    }

    public void delete(Note note) {
        new DeleteAsyncTask(noteDao).execute(note);
    }

    public void deleteAll() {
        new DeleteAllAsyncTask(noteDao).execute();
    }

    public LiveData<List<Note>> getAllNotes() {
        return allNotes;
    }

    private class InsertAsyncTask extends AsyncTask<Note, Void, Void> {

        private NoteDAO noteDAO;

        InsertAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.insert(notes[0]);
            return null;
        }
    }

    private class UpdateAsysncTask extends AsyncTask<Note, Void, Void> {

        private NoteDAO noteDAO;

        UpdateAsysncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected  Void doInBackground(Note... notes) {
            noteDAO.update(notes[0]);
            return null;
        }
    }

    private class DeleteAsyncTask extends  AsyncTask<Note, Void, Void> {

        private NoteDAO noteDAO;

        DeleteAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Note... notes) {
            noteDAO.delete(notes[0]);
            return null;
        }
    }

    private class DeleteAllAsyncTask extends AsyncTask<Void, Void, Void> {

        private NoteDAO noteDAO;

        DeleteAllAsyncTask(NoteDAO noteDAO) {
            this.noteDAO = noteDAO;
        }

        @Override
        protected Void doInBackground(Void... voids) {
            noteDAO.deleteAll();
            return null;
        }
    }

}
