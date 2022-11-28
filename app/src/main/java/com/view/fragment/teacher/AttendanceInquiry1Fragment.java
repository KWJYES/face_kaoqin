package com.view.fragment.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.base.BaseFragment;
import com.callback.CourseItemOnClickListener;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.FragmentAttendanceInquiry1Binding;
import com.viewmodel.rvm.fragment.teacher.AttendanceInquiry1RVM;
import com.viewmodel.svm.fragment.teacher.AttendanceInquiry1SVM;


public class AttendanceInquiry1Fragment extends BaseFragment {


    AttendanceInquiry1SVM svm;
    AttendanceInquiry1RVM rvm;
    FragmentAttendanceInquiry1Binding binding;
    private CourseItemOnClickListener courseItemOnClickListener;

    public AttendanceInquiry1Fragment(CourseItemOnClickListener courseItemOnClickListener) {
        this.courseItemOnClickListener = courseItemOnClickListener;
    }

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AttendanceInquiry1SVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AttendanceInquiry1RVM.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_attendance_inquiry1, container, false);
        binding.setSvm(svm);
        binding.setClick(new ClickClass());
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    protected void initView() {
        binding.rvCourse.setLayoutManager(new LinearLayoutManager(getActivity()));
    }

    public class ClickClass{

    }
}