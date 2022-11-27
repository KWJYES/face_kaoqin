package com.viewmodel.rvm.activity.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;

public class TeacherLoginRVM extends ViewModel {
    public MutableLiveData<Boolean> loginStatus = new MutableLiveData<>();

    public void login(String email, String password) {
        HttpRequestManager.getInstance().teacherLogin(email,password,loginStatus);
    }
}
