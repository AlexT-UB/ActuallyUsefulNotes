package com.example.actuallyusefulnotes.Model;

import java.io.Serializable;
import java.util.ArrayList;

public class Group implements Serializable {
    private String admin;
    private String title;
    private ArrayList<String> userList;
    private String date_created;
    private String adminUID;

    public Group (String admin, String title, ArrayList<String> userList){
        this.userList = userList;
        this.title = title;
        this.admin = admin;
    }
    public Group(){
    }

    public void addUser(String username) throws Exception{
        if(userList.size() < 20){
            userList.add(username);
        } else {
            throw new Exception("Maximum Number Of Users In Group Reached");
        }
    }

    public void deleteUser(String username) throws Exception{
        if(userList.contains(username)) {
            userList.remove(username);
        } else {
            throw new Exception("User Not In Group");
        }
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAdmin() {
        return admin;
    }

    public void setAdmin(String admin) {
        this.admin = admin;
    }

    public ArrayList<String> getUserList() {
        return userList;
    }

    public void setUserList(ArrayList<String> userList) {
        this.userList = userList;
    }

    public String getDate_created() {
        return date_created;
    }

    public void setDate_created(String date_created) {
        this.date_created = date_created;
    }

    public String getAdminUID() {
        return adminUID;
    }

    public void setAdminUID(String adminUID) {
        this.adminUID = adminUID;
    }
}
