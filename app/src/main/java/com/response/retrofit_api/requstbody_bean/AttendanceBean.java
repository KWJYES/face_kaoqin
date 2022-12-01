package com.response.retrofit_api.requstbody_bean;

public class AttendanceBean {
    private String course_id;
    private String student_id;
    private String lesson_time;
    private String attendance_time;

    public String getAttendance_time() {
        return attendance_time;
    }

    public void setAttendance_time(String attendance_time) {
        this.attendance_time = attendance_time;
    }

    public String getCourse_id() { return course_id; }
    public void setCourse_id(String value) { this.course_id = value; }



    public String getStudent_id() { return student_id; }
    public void setStudent_id(String value) { this.student_id = value; }

    public String getLesson_time() {
        return lesson_time;
    }

    public void setLesson_time(String lesson_time) {
        this.lesson_time = lesson_time;
    }

    @Override
    public String toString() {
        return "AttendanceBean{" +
                "course_id='" + course_id + '\'' +
                ", student_id='" + student_id + '\'' +
                ", lesson_time='" + lesson_time + '\'' +
                ", attendance_time='" + attendance_time + '\'' +
                '}';
    }
}
