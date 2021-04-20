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
