package com.viewmodel.rvm.fragment.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.resposebody_bean.InquireCourseJoinBean;

import java.util.List;

public class StudentHomeRVM extends ViewModel {
    public MutableLiveData<Boolean> joinInState=new MutableLiveData<>();

    public void joinInCourse(CourseID bean){
        HttpRequestManager.getInstance().joinCourse(bean,joinInState);
    }

    public MutableLiveData<List<InquireCourseJoinBean.Message>> courseList=new MutableLiveData<>();
    public MutableLiveData<Boolean> inquireCourseState=new MutableLiveData<>();
    public void inquireCourse(){
        HttpRequestManager.getInstance().inquireCourseJoinCourse(inquireCourseState,courseList);
    }
}
