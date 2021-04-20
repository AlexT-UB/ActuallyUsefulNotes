package com.example.actuallyusefulnotes;

public class Reminder extends BasicNote{
    long time;
    String text;

    public Reminder(String creador, String nom, String categoria, long preTime, String preText){
        super(creador, nom, categoria);
        time = preTime;
        text= preText;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
