package com.callback;

import com.response.retrofit_api.resposebody_bean.InquireCourseBean;

public interface CourseItemOnClickListener {
    void onClick(InquireCourseBean.Message course);
}
