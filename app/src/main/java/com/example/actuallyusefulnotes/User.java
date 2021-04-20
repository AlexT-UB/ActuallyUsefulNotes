package com.example.actuallyusefulnotes;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;
    private List<Note> errasedNotes;

    public User (String name, String mail, String security){
        username = name;
        email = mail;
        password = security;
        List<Note> errasedNotes = new ArrayList<Note>();
    }
    
}
