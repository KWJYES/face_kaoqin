package com.response.retrofit_api.requstbody_bean;

public class InquireAttendanceBean {

    private String course_id;
    private String attendance_time;
    private String lessons_time;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getAttendance_time() {
        return attendance_time;
    }

    public void setAttendance_time(String attendance_time) {
        this.attendance_time = attendance_time;
    }

    public String getLessons_time() {
        return lessons_time;
    }

    public void setLessons_time(String lessons_time) {
        this.lessons_time = lessons_time;
    }
}
