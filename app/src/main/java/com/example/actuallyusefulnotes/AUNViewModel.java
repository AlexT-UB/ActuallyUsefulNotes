package com.example.actuallyusefulnotes;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

public class AUNViewModel extends ViewModel {
    private MutableLiveData<List<User>> users;

    public AUNViewModel() {
        this.users = new MutableLiveData<>();
    }
}

