package com.viewmodel.rvm.activity.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.requstbody_bean.AttendanceBean;

public class AttendanceRVM extends ViewModel {
    public MutableLiveData<Boolean> attendanceState=new MutableLiveData<>();

    public void attendance(AttendanceBean bean){
        HttpRequestManager.getInstance().attendanceRecord(bean,attendanceState);
    }
}
