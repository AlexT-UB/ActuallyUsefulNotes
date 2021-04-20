package com.example.actuallyusefulnotes;

public class Note extends BasicNote{
    private String text;
    public Note (String creador, String nom, String categoria, String preText){
        super(creador, nom, categoria);
        text = preText;
    }
}
