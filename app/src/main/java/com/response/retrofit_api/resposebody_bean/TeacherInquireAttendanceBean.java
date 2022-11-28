package com.response.retrofit_api.resposebody_bean;

import java.util.List;

public class TeacherInquireAttendanceBean {

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
        private String student_id;
        private String student_name;

        public String getAttendance_state() {
            return attendance_state;
        }

        public void setAttendance_state(String attendance_state) {
            this.attendance_state = attendance_state;
        }

        public String getStudent_id() {
            return student_id;
        }

        public void setStudent_id(String student_id) {
            this.student_id = student_id;
        }

        public String getStudent_name() {
            return student_name;
        }

        public void setStudent_name(String student_name) {
            this.student_name = student_name;
        }
    }
}
