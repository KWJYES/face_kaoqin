package com.response.retrofit_api;

import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.requstbody_bean.StudentID;
import com.response.retrofit_api.resposebody_bean.InquireAttendanceBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseJoinBean;
import com.response.retrofit_api.resposebody_bean.JoinInCourseSucceed;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IStudentService {
    /**
     * 学生注册
     *
     * @param email
     * @param captcha
     * @param username
     * @param student_id
     * @param password
     * @param password_confirm
     * @return
     */
    @FormUrlEncoded
    @POST("/user/student_register")
    Call<ResponseBody> register(@Field("email") String email,
                                @Field("captcha") String captcha,
                                @Field("username") String username,
                                @Field("student_id") String student_id,
                                @Field("password") String password,
                                @Field("password_confirm") String password_confirm
    );

    /**
     * 学生登陆
     *
     * @param email
     * @param password
     * @return
     */
    @FormUrlEncoded
    @POST("/user/student_login")
    Call<ResponseBody> login(@Field("email") String email, @Field("password") String password);

    /**
     * 查询加入的课程
     *
     * @return
     */
    @POST("/user/inquire_joincourse")
    Call<InquireCourseJoinBean> inquireCourseJoinBean();

    /**
     * 加入课程
     *
     * @param body
     * @return
     */
    @POST("/user/join_course")
    Call<JoinInCourseSucceed> joinCourse(@Body CourseID body);

    /**
     * 退出课程
     *
     * @param body
     * @return
     */
    @POST("/user/quit_course")
    Call<ResponseBody> quitCourse(@Body CourseID body);

    /**
     * 获取自己的考勤情况
     * @param studentID {
     *   "student_id": 2000300115
     * }
     * @return
     */
    @POST("/user/inquire_attendance")
    Call<InquireAttendanceBean> inquireAttendance(@Body StudentID studentID);
}
