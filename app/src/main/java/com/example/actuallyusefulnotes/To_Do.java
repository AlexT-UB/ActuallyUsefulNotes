package com.example.actuallyusefulnotes;

import java.util.Dictionary;
import java.util.Hashtable;

public class To_Do extends BasicNote{
    Dictionary list;

    public To_Do(String creador, String nom, String categoria, String[] preList){
        super(creador, nom, categoria);
        list = new Hashtable();
        for(int x = 0; x < preList.length; x++){
            list.put(preList[x], false);
        }
    }

    public Dictionary getList() {
        return list;
    }

    public void setList(Dictionary list) {
        this.list = list;
    }
}
