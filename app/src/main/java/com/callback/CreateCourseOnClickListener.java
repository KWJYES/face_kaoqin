package com.callback;

import com.response.retrofit_api.requstbody_bean.CourseCreateBean;

public interface CreateCourseOnClickListener {
    void createCourse(CourseCreateBean bean);
}
