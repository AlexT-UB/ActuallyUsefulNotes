package com.example.actuallyusefulnotes.ViewModel;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.actuallyusefulnotes.Model.User;

import java.util.List;

public class AUNViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;

    public LiveData<List<User>> getUsers() {
        if (users == null){
            users = new MutableLiveData<List<User>>();

        }
        return users;
    }
}

