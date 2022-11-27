package com.viewmodel.svm.activity.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.retrofit_api.resposebody_bean.InquireCourseBean;

public class TeacherCourseSVM extends ViewModel {
    public MutableLiveData<String> course_name=new MutableLiveData<>();
    public MutableLiveData<String> course_id=new MutableLiveData<>();
    public MutableLiveData<String> teacher_id=new MutableLiveData<>();
    public MutableLiveData<String> course_time=new MutableLiveData<>();
    public MutableLiveData<InquireCourseBean.Message> course=new MutableLiveData<>();
}
