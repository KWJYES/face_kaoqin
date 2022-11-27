package com.viewmodel.rvm.activity.student;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.requstbody_bean.StudentID;
import com.response.retrofit_api.resposebody_bean.InquireAttendanceBean;

import java.util.List;

public class StudentAttendanceRecordRVM extends ViewModel {
    public MutableLiveData<Boolean> requireState=new MutableLiveData<>();
    public MutableLiveData<List<InquireAttendanceBean.Message>> recordList=new MutableLiveData<>();
    public void getAttendance(StudentID studentID){
        HttpRequestManager.getInstance().studentInquireAttendance(studentID,recordList,requireState);
    }
}
