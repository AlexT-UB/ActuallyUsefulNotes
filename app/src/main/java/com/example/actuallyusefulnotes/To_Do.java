package com.example.actuallyusefulnotes;

import java.util.Dictionary;
import java.util.Hashtable;
import java.util.List;

public class To_Do extends BasicNote{
    Dictionary list;

    public To_Do (String titulo, String categoria, String date, String time, String author, List list){
        super(titulo, categoria, date, time, author);
        this.list = new Hashtable();
        for(int x = 0; x < list.size(); x++){
            this.list.put(list.get(x), false);
        }
    }

    public Dictionary getList() {
        return list;
    }

    public void setList(Dictionary list) {
        this.list = list;
    }

    public void addEvent(String event){
        this.list.put(event, false);
    }

    public void deleteEvent(String event){
        this.list.remove(event);
    }

    public Object getEventCompleted(String event){
        return this.list.get(event);
    }
}
