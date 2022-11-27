package com.viewmodel.svm.activity.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class StudentCourseSVM extends ViewModel {
    public MutableLiveData<String> course_name=new MutableLiveData<>();
    public MutableLiveData<String> course_id=new MutableLiveData<>();
    public MutableLiveData<String> student_id=new MutableLiveData<>();
}
