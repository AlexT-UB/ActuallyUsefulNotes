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

    public String getCreator(){
        return creator;
    }

    public void setCreator(String newCreator){
        creator = newCreator;
    }

    public String getCategory(){
        return category;
    }

    public void setCategory(String newCategory){
        category = newCategory;
    }

    public String getName(){
        return name;
    }

    public void setName(String newName){
        name = newName;
    }

    public long getLastEdited(){
        return lastEdited;
    }

    public void setLastEdited(long newLastEdited){
        lastEdited = newLastEdited;
    }

}

/*public class BasicNote {
    private long ID;
    private String titulo;
    private String categoria;
    private String date;
    private String time;

    protected BasicNote(String titulo, String categoria, String date, String time){
        this.categoria = categoria;
        this.time = time;
        this.date = date;
        this.titulo = titulo;
    }

    protected BasicNote(long ID, String titulo, String categoria, String date, String time) {
        this.ID = ID;
        this.categoria = categoria;
        this.time = time;
        this.date = date;
        this.titulo = titulo;
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
}*/

