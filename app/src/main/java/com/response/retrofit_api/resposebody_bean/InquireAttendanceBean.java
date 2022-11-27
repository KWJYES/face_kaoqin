package com.response.retrofit_api.resposebody_bean;

import java.util.List;

public class InquireAttendanceBean {

    private Integer code;
    private List<Message> message;

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Message> getMessage() {
        return message;
    }

    public void setMessage(List<Message> message) {
        this.message = message;
    }

    public static class Message {
        private String attendance_state;
        private String attendance_time;
        private String course_id;
        private String course_name;
        private Integer id;
        private String lessons_time;
        private String student_id;

        public String getAttendance_state() {
            return attendance_state;
        }

        public void setAttendance_state(String attendance_state) {
            this.attendance_state = attendance_state;
        }

        public String getAttendance_time() {
            return attendance_time;
        }

        public void setAttendance_time(String attendance_time) {
            this.attendance_time = attendance_time;
        }

        public String getCourse_id() {
            return course_id;
        }

        public void setCourse_id(String course_id) {
            this.course_id = course_id;
        }

        public String getCourse_name() {
            return course_name;
        }

        public void setCourse_name(String course_name) {
            this.course_name = course_name;
        }

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public String getLessons_time() {
            return lessons_time;
        }

        public void setLessons_time(String lessons_time) {
            this.lessons_time = lessons_time;
        }

        public String getStudent_id() {
            return student_id;
        }

        public void setStudent_id(String student_id) {
            this.student_id = student_id;
        }
    }
}
