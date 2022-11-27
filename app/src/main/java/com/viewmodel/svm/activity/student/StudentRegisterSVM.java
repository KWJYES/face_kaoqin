package com.viewmodel.svm.activity.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudentRegisterSVM extends ViewModel {
    public MutableLiveData<String> email=new MutableLiveData<>();
    public MutableLiveData<String> captcha=new MutableLiveData<>();
    public MutableLiveData<String> username=new MutableLiveData<>();
    public MutableLiveData<String> student_id=new MutableLiveData<>();
    public MutableLiveData<String> password=new MutableLiveData<>();
    public MutableLiveData<String> password_confirm=new MutableLiveData<>();
}
