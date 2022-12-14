package com.response.retrofit_api;

import com.response.retrofit_api.requstbody_bean.AttendanceBean;
import com.response.retrofit_api.requstbody_bean.CheckCourseExistBean;
import com.response.retrofit_api.requstbody_bean.CourseCreateBean;
import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.requstbody_bean.InputAttendanceRecordBean;
import com.response.retrofit_api.requstbody_bean.InquireAttendanceBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.response.retrofit_api.resposebody_bean.TeacherInquireAttendanceBean;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ITeacherService {

    /**
     * 某学生打卡成功
     * @param body
     * @return
     */
    @POST("/teacher/attendance_record")
    Call<ResponseBody> attendance_record(@Body AttendanceBean body);

    /**
     * 老师注册
     * @param email
     * @param captcha
     * @param username
     * @param student_id
     * @param password
     * @param password_confirm
     * @return
     */
    @FormUrlEncoded
    @POST("/teacher/teacher_register")
    Call<ResponseBody> register(@Field("email") String email,
                                @Field("captcha")String captcha,
                                @Field("username")String username,
                                @Field("student_id")String student_id,
                                @Field("password")String password,
                                @Field("password_confirm")String password_confirm
    );

    /**
     * 老师登陆
     * @param email
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/teacher/teacher_login")
    Call<ResponseBody> login(@Field("email") String email,@Field("password") String password);

    /**
     * 查询所有课号
     * @return
     */
    @POST("/teacher/inquire_course")
    Call<InquireCourseBean> inquireCourse();

    /**
     * 创建课程
     * @param body {
     *   "course_id": 123456,
     *   "course_name": "语文课",
     *   "teacher_id": 20221004
     * }
     * @return
     */
    @POST("/teacher/create_course")
    Call<ResponseBody> createCourse(@Body CourseCreateBean body);

    /**
     * 查询课号是否存在
     * @param body {
     *   "course_id": "123456"
     * }
     * @return
     */
    @POST("/teacher/check_course_exist")
    Call<ResponseBody> checkCourseExist(@Body CheckCourseExistBean body);

    /**
     * 添加发起的考勤进入数据库
     * @param body {
     *   "course_id": 123456,
     *   "lessons_time": "二"
     * }
     * @return
     */
    @POST("/teacher/input_attendenceRecord")
    Call<ResponseBody> inputAttendanceRecord(@Body InputAttendanceRecordBean body);

    /**
     * （新）考勤查询
     * @param body {
     *   "course_id": 123456,
     *   "attendance_time": "2022-11-19",
     *   "lessons_time": "三"
     * }
     * @return
     */
    @POST("/teacher/inquire_attendance")
    Call<TeacherInquireAttendanceBean> teacherInquire_attendance(@Body InquireAttendanceBean body);

    /**
     * 删除课程
     * @param body {
     *   "course_id": 123456
     * }
     * @return
     */
    @POST("/teacher/delete_course")
    Call<ResponseBody> teacherDelete_course(@Body CourseID body);
}
