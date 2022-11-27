package com.viewmodel.rvm.activity.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.requstbody_bean.InputAttendanceRecordBean;

public class TeacherCourseRVM extends ViewModel {
    public MutableLiveData<Boolean> input_attendanceRecordState=new MutableLiveData<>();

    public void inputAttendanceRecord(InputAttendanceRecordBean bean){
        HttpRequestManager.getInstance().inputAttendanceRecord(input_attendanceRecordState,bean);
    }
}
