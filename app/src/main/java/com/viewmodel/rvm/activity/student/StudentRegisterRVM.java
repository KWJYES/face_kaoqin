package com.viewmodel.rvm.activity.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;

public class StudentRegisterRVM extends ViewModel {
    public MutableLiveData<Boolean> getCaptchaStatus = new MutableLiveData<>();
    public MutableLiveData<String> captcha = new MutableLiveData<>();

    public void getCaptcha(String email) {
        HttpRequestManager.getInstance().getCaptcha(email, getCaptchaStatus);
    }

    public MutableLiveData<Boolean> registerStatus = new MutableLiveData<>();

    public void register(String email,
                         String captcha,
                         String username,
                         String student_id,
                         String password,
                         String password_confirm) {
        HttpRequestManager.getInstance().studentRegister(
                email, captcha, username, student_id, password, password_confirm, registerStatus);
    }
}
