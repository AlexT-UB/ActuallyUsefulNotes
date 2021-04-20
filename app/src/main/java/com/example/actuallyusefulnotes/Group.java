package com.example.actuallyusefulnotes;

import java.util.ArrayList;
import java.util.List;

public class Group {;
    private String admin;
    private User[] userList;
    private List<BasicNote> notes;

    public Group (String administrator, User[] protoList){
        userList = protoList;
        admin = administrator;
        notes = new ArrayList<BasicNote>();
    }
}
