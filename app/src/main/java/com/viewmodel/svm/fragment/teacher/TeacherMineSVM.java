package com.viewmodel.svm.fragment.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class TeacherMineSVM extends ViewModel {
    public MutableLiveData<String> teacher_id=new MutableLiveData<>();
    public MutableLiveData<String> teacher_name=new MutableLiveData<>();
}
