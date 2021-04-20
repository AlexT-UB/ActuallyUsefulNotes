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

    public void deletedBasicNote(BasicNote deleted){
        errasedNotes.add(deleted);
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<BasicNote> getErrasedNotes() {
        return errasedNotes;
    }

    public void setErrasedNotes(List<BasicNote> errasedNotes) {
        this.errasedNotes = errasedNotes;
    }
}
