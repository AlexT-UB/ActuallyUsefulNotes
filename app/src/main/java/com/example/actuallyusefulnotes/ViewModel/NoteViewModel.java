package com.example.actuallyusefulnotes.ViewModel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.example.actuallyusefulnotes.Model.Note;
import com.example.actuallyusefulnotes.NoteRepository;

import java.util.List;

public class NoteViewModel extends AndroidViewModel {

    private NoteRepository noteRepository;
    private List<Note> allNotes;

    public NoteViewModel(@NonNull Application application) {
        super(application);
        noteRepository = new NoteRepository(application);
        allNotes = noteRepository.getAllNotes();
    }

    public void insert(Note note) {
        noteRepository.insert(note);
    }

    public void update(Note note) {
        noteRepository.update(note);
    }

    public void delete(Note note) {
        noteRepository.delete(note);
    }

    public void deleteAll() {
        noteRepository.deleteAll();
    }

    public List<Note> getAllNotes() {
        return allNotes;
    }
}
