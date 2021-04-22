package com.example.actuallyusefulnotes;

public class Note extends BasicNote{
    private String text;
    public Note (String text, String titulo, String categoria, String date, String time, String author){
        super(titulo, categoria, date, time, author);
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
