package com.viewmodel.svm.fragment.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class AttendanceInquiry2SVM extends ViewModel {
    public MutableLiveData<String> dateString=new MutableLiveData<>();
    public MutableLiveData<String> lessonTime=new MutableLiveData<>();
}
