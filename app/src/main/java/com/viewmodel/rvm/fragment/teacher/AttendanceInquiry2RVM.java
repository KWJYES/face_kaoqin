package com.viewmodel.rvm.fragment.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.requstbody_bean.InquireAttendanceBean;
import com.response.retrofit_api.resposebody_bean.TeacherInquireAttendanceBean;

import java.util.List;

public class AttendanceInquiry2RVM extends ViewModel {
    public MutableLiveData<Boolean> requestState=new MutableLiveData<>();
    public MutableLiveData<List<TeacherInquireAttendanceBean.Message>> list=new MutableLiveData<>();

    public void inquireAttendance(String course_id,String attendance_time,String lessons_time){
        InquireAttendanceBean inquireAttendanceBean=new InquireAttendanceBean();
        inquireAttendanceBean.setAttendance_time(attendance_time);
        inquireAttendanceBean.setCourse_id(course_id);
        inquireAttendanceBean.setLessons_time(lessons_time);
        HttpRequestManager.getInstance().teacherInquire_attendance(inquireAttendanceBean,list,requestState);
    }
}
