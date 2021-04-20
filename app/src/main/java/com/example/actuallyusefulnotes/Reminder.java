package com.example.actuallyusefulnotes;

public class Reminder extends BasicNote{
    long time;
    String text;

    public Reminder(String creador, String nom, String categoria, long preTime, String preText){
        super(creador, nom, categoria);
        time = preTime;
        text= preText;
    }
}
