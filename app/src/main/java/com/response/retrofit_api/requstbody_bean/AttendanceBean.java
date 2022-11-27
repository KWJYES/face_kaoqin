package com.response.retrofit_api.requstbody_bean;

public class AttendanceBean {
    private String course_id;
    private String course_time;
    private String student_id;

    public String getCourse_id() { return course_id; }
    public void setCourse_id(String value) { this.course_id = value; }

    public String getCourse_time() { return course_time; }
    public void setCourse_time(String value) { this.course_time = value; }

    public String getStudent_id() { return student_id; }
    public void setStudent_id(String value) { this.student_id = value; }
}
