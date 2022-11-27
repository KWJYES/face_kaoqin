package com.response.network;

import androidx.lifecycle.MutableLiveData;

import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.requstbody_bean.StudentID;
import com.response.retrofit_api.resposebody_bean.InquireAttendanceBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseJoinBean;

import java.util.List;

public interface IStudentNetworkRequest {
    /**
     * 学生注册
     * @param email 邮箱
     * @param captcha 验证码
     * @param username 姓名
     * @param student_id 学号
     * @param password 密码
     * @param password_confirm 确认密码
     * @param state 网络请求是否成功
     */
    void studentRegister(String email,
                         String captcha,
                         String username,
                         String student_id,
                         String password,
                         String password_confirm,
                         MutableLiveData<Boolean> state);

    /**
     * 学生登陆
     * @param email 邮箱
     * @param password 密码
     * @param state 网络请求状态
     */
    void studentLogin(String email, String password, MutableLiveData<Boolean> state);

    /**
     * 查询加入的课程
     * @param inquireCourseState
     * @param courseList
     */
    void inquireCourseJoinCourse(MutableLiveData<Boolean> inquireCourseState, MutableLiveData<List<InquireCourseJoinBean.Message>> courseList);

    /**
     * 传入课号
     * 加入某课程
     * @param body
     * @param joinInState
     */
    void joinCourse(CourseID body,MutableLiveData<Boolean> joinInState);

    /**
     * 退出课程
     * @param body
     * @param quitInState
     */
    void quitCourse(CourseID body,MutableLiveData<Boolean> quitInState);

    /**
     * 获取自己的考勤情况
     * @param body
     * @param recordList
     * @param state
     */
    void studentInquireAttendance(StudentID body,MutableLiveData<List<InquireAttendanceBean.Message>> recordList, MutableLiveData<Boolean> state);
}
