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
        if(legnthList == 20)
            throw new Exception("Maximum Number Of Users In Group");
        else
            userList[legnthList] = username;
    }

    public void deleteUser(String username) throws Exception{
        int legnthArray = userList.length;
        int index = 0;
        if(legnthArray == 0)
            throw new Exception("No Users In Group");
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
}
