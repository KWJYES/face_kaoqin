package com.viewmodel.rvm.activity.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;

public class StudentLoginRVM extends ViewModel {
    public MutableLiveData<Boolean> loginStatus = new MutableLiveData<>();

    public void login(String email, String password) {
        HttpRequestManager.getInstance().studentLogin(email,password,loginStatus);
    }

}
