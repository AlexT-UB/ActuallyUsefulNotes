package com.example.actuallyusefulnotes;

import androidx.lifecycle.LiveData;

import com.example.actuallyusefulnotes.Model.Note;

import java.util.List;

public interface NoteDAO {
    void insert(Note note);
    void delete(Note note);
    void update(Note note);
    void deleteAll();
    LiveData<List<Note>> getAllNotes();
}
