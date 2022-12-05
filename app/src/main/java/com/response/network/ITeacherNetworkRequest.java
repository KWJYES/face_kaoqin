package com.response.network;

import androidx.lifecycle.MutableLiveData;

import com.response.retrofit_api.requstbody_bean.AttendanceBean;
import com.response.retrofit_api.requstbody_bean.CheckCourseExistBean;
import com.response.retrofit_api.requstbody_bean.CourseCreateBean;
import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.requstbody_bean.InputAttendanceRecordBean;
import com.response.retrofit_api.requstbody_bean.InquireAttendanceBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.response.retrofit_api.resposebody_bean.TeacherInquireAttendanceBean;

import java.util.List;

public interface ITeacherNetworkRequest {

    /**
     * 签到
     * @param bean course_id student_id course_time
     * @param requestState 网络请求是否成功
     */
    void attendanceRecord(AttendanceBean bean, MutableLiveData<Boolean> requestState);

    /**
     * 老师注册
     * @param email 邮箱
     * @param captcha 验证码
     * @param username 姓名
     * @param student_id 学号
     * @param password 密码
     * @param password_confirm 确认密码
     * @param state 网络请求是否成功
     */
    void teacherRegister(String email,
                         String captcha,
                         String username,
                         String student_id,
                         String password,
                         String password_confirm,
                         MutableLiveData<Boolean> state);

    /**
     * 老师登陆
     * @param email 邮箱
     * @param password 密码
     * @param state 网络请求状态
     */
    void teacherLogin(String email, String password, MutableLiveData<Boolean> state);

    /**
     * 创建课程
     * @param bean 课程 {
     *   "course_id": 123456,
     *   "course_name": "语文课",
     *   "teacher_id": 20221004
     * }
     * @param state 请求状态
     */
    void createCourse(CourseCreateBean bean,MutableLiveData<Boolean> state);

    /**
     * 查询课号是否存在
     * @param bean 课程id {
     *   "course_id": "123456"
     * }
     * @param state 请求状态
     */
    void checkCourseExist(CheckCourseExistBean bean,MutableLiveData<String> msg,MutableLiveData<Boolean> state);

    /**
     * 查询所有课号
     * @param data 返回的所有课程liveData
     * @param state 请求状态
     */
    void inquireCourse(MutableLiveData<List<InquireCourseBean.Message>> data, MutableLiveData<Boolean> state);

    /**
     * 添加发起的考勤进入数据库
     * @param state
     * @param bean {
     *   "course_id": 123456,
     *   "lessons_time": "二"
     * }
     */
    void inputAttendanceRecord(MutableLiveData<Boolean> state, InputAttendanceRecordBean bean);

    /**
     * 考勤查询
     * @param inquireAttendanceBean {
     *   "course_id": 123456,
     *   "attendance_time": "2022-11-19",
     *   "lessons_time": "三"
     * }
     * @param list
     * @param state
     */
    void teacherInquire_attendance(InquireAttendanceBean inquireAttendanceBean,MutableLiveData<List<TeacherInquireAttendanceBean.Message>> list,MutableLiveData<Boolean> state);


    /**
     * 删除课程
     * @param courseID {
     *   "course_id": 123456
     * }
     * @param state
     */
    void teacherDelete_course(CourseID courseID,MutableLiveData<Boolean> state);
}
