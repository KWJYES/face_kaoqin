package com.viewmodel.rvm.activity.teacher;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.response.network.HttpRequestManager;
import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.requstbody_bean.InputAttendanceRecordBean;

public class TeacherCourseRVM extends ViewModel {
    public MutableLiveData<Boolean> input_attendanceRecordState=new MutableLiveData<>();

    public void inputAttendanceRecord(InputAttendanceRecordBean bean){
        HttpRequestManager.getInstance().inputAttendanceRecord(input_attendanceRecordState,bean);
    }

    public MutableLiveData<Boolean> deleteCourseState=new MutableLiveData<>();

    public void deleteCourse(CourseID courseID){
        HttpRequestManager.getInstance().teacherDelete_course(courseID,deleteCourseState);
    }
}
