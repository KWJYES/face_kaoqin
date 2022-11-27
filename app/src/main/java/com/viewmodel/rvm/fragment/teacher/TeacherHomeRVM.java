package com.viewmodel.rvm.fragment.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.requstbody_bean.CheckCourseExistBean;
import com.response.retrofit_api.requstbody_bean.CourseCreateBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;

import java.util.List;

public class TeacherHomeRVM extends ViewModel {
    public MutableLiveData<Boolean> createState=new MutableLiveData<>();

    public void createCourse(CourseCreateBean bean){
        HttpRequestManager.getInstance().createCourse(bean,createState);
    }

    public MutableLiveData<Boolean> checkCourseExistState=new MutableLiveData<>();
    public MutableLiveData<String> checkCourseExistMsg=new MutableLiveData<>();

    public void checkCourseExist(CheckCourseExistBean bean){
        HttpRequestManager.getInstance().checkCourseExist(bean,checkCourseExistMsg,checkCourseExistState);
    }

    public MutableLiveData<List<InquireCourseBean.Message>> courseList=new MutableLiveData<>();
    public MutableLiveData<Boolean> inquireCourseState=new MutableLiveData<>();
    public void inquireCourse(){
        HttpRequestManager.getInstance().inquireCourse(courseList,inquireCourseState);
    }
}
