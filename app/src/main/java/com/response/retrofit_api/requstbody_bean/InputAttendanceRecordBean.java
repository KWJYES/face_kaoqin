package com.response.retrofit_api.requstbody_bean;

public class InputAttendanceRecordBean {
    private String course_id;
    private String lessons_time;

    public String getCourse_id() {
        return course_id;
    }

    public void setCourse_id(String course_id) {
        this.course_id = course_id;
    }

    public String getLessons_time() {
        return lessons_time;
    }

    public void setLessons_time(String lessons_time) {
        this.lessons_time = lessons_time;
    }
}
