package com.view.fragment.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.base.BaseFragment;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;

public class AttendanceInquiry2Fragment extends BaseFragment {
    private InquireCourseBean.Message course;

    public AttendanceInquiry2Fragment(InquireCourseBean.Message course) {
        this.course = course;
    }

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return null;
    }
}