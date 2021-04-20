package com.example.actuallyusefulnotes;

import java.util.ArrayList;
import java.util.List;

public class User {
    private String username;
    private String email;
    private String password;
    private List<BasicNote> errasedNotes;

    public User (String name, String mail, String security){
        username = name;
        email = mail;
        password = security;
        errasedNotes = new ArrayList<BasicNote>();
    }
    
}
