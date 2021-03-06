package com.example.actuallyusefulnotes;

import android.app.Application;
import android.os.AsyncTask;

import androidx.lifecycle.LiveData;

import com.example.actuallyusefulnotes.Model.Note;

import java.util.List;

public class NoteRepository {

    private NoteDAO noteDAO;
    private List<Note> allNotes;

    public NoteRepository(Application application) {
        NoteDataBase noteDataBase = NoteDataBase.getInstance(application);
        noteDAO = noteDataBase.noteDAO();
        allNotes = noteDAO.getAllNotes();
    }

    public void insert(Note note) {
        new InsertAsyncTask(noteDAO).execute(note);
    }

    public void update(Note note) {
        new UpdateAsysncTask(noteDAO).execute(note);
    }

    public void delete(Note note) {
        new DeleteAsyncTask(noteDAO).execute(note);
    }

    public void deleteAll() {
        new DeleteAllAsyncTask(noteDAO).execute();
    }

    public List<Note> getAllNotes() {
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
