package com.example.actuallyusefulnotes;

public class BasicNote {
    String creator;
    String name;
    String category;
    long lastEdited;

    protected BasicNote(String creador, String nom, String categoria){
        creator = creador;
        name = nom;
        category = categoria;
        lastEdited = System.currentTimeMillis();
    }
}
