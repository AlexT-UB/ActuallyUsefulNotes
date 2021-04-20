package com.example.actuallyusefulnotes;

import androidx.core.content.res.TypedArrayUtils;

import java.util.ArrayList;
import java.util.List;

public class Group {;
    private String admin;
    private String[] userList;
    private List<BasicNote> notes;

    public Group (String administrator, String[] protoList){
        userList = protoList;
        admin = administrator;
        notes = new ArrayList<BasicNote>();
    }

    public void addUser(String username) throws Exception{
        int legnthList = userList.length;
        for (int x = 0; x < legnthList - 1; x++)
            if(userList[x].equals("NoUser")) {
                userList[x] = username;
                return;
            }
        throw new Exception("Maximum Number Of Users In Group Reached");
    }

    public void deleteUser(String username) throws Exception{
        int legnthArray = userList.length;
        int index = 0;
        for (int x = 0; x < legnthArray-1; x++)
            if(userList[x].equals(username)){
                index = x;
                break;}
            else
                throw new Exception("User Not In Group");
        for (int x = index; x <  legnthArray-1; x++)
            userList[x] = userList[x+1];
        userList[legnthArray-1] = "NoUser";
    }

    public List<BasicNote> seeCategory(String category){
        int lenghtNotes = notes.size() - 1;
        List<BasicNote> categoryList = new ArrayList<BasicNote>();
        for(int x = 0; x < lenghtNotes; x++)
            if(notes.get(x).getCategory().equals(category))
                categoryList.add(notes.get(x));
        return categoryList;
    }

    public List<BasicNote> getNotes() {
        return notes;
    }

    public void setNotes(List<BasicNote> notes) {
        this.notes = notes;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public String[] getUserList() {
        return userList;
    }

    public void setUserList(String[] userList) {
        this.userList = userList;
    }
}
