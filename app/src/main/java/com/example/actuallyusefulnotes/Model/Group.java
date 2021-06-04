package com.example.actuallyusefulnotes.Model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class Group implements Serializable {
    private String admin;
    private String title;
    private String[] userList;
    private String date_created;
    private String adminUID;

    public Group (String admin, String title, String[] userList){
        this.userList = userList;
        this.title = title;
        this.admin = admin;
    }
    public Group(){
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

    public String[] getUserList() {
        return userList;
    }

    public void setUserList(String[] userList) {
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
