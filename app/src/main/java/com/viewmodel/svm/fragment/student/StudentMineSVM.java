package com.viewmodel.svm.fragment.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudentMineSVM extends ViewModel {
    public MutableLiveData<String> student_id=new MutableLiveData<>();
    public MutableLiveData<String> student_name=new MutableLiveData<>();
}
