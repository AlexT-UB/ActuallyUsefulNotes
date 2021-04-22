package com.example.actuallyusefulnotes;

public class BasicNote {
    private long ID;
    private String titulo;
    private String categoria;
    private String date;
    private String time;
    private String author;

    protected BasicNote(String titulo, String categoria, String date, String time, String author){
        this.categoria = categoria;
        this.time = time;
        this.date = date;
        this.titulo = titulo;
        this.author = author;
    }

    protected BasicNote(long ID, String titulo, String categoria, String date, String time, String author) {
        this.ID = ID;
        this.categoria = categoria;
        this.time = time;
        this.date = date;
        this.titulo = titulo;
        this.author = author;
    }

    public long getID() {
        return ID;
    }

    public void setID(long ID) {
        this.ID = ID;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }
}

