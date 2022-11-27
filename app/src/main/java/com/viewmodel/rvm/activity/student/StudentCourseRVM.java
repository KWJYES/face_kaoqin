package com.viewmodel.rvm.activity.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.requstbody_bean.CourseID;

public class StudentCourseRVM extends ViewModel {
    public MutableLiveData<Boolean> quitCourseState=new MutableLiveData<>();
    public void quitCourse(CourseID courseID){
        HttpRequestManager.getInstance().quitCourse(courseID,quitCourseState);
    }
}
