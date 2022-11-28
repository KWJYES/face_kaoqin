package com.viewmodel.rvm.fragment.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;

import java.util.List;

public class AttendanceInquiry1RVM extends ViewModel {
    public MutableLiveData<List<InquireCourseBean.Message>> courseList=new MutableLiveData<>();
    public MutableLiveData<Boolean> inquireCourseState=new MutableLiveData<>();
    public void inquireCourse(){
        HttpRequestManager.getInstance().inquireCourse(courseList,inquireCourseState);
    }
}
