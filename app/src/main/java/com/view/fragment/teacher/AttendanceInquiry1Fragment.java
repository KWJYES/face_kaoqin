package com.view.fragment.teacher;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.adapter.teacher.CourseInquireAttendanceAdapter;
import com.base.BaseFragment;
import com.callback.CourseItemOnClickListener;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.FragmentAttendanceInquiry1Binding;
import com.viewmodel.rvm.fragment.teacher.AttendanceInquiry1RVM;
import com.viewmodel.svm.fragment.teacher.AttendanceInquiry1SVM;

import java.util.List;


public class AttendanceInquiry1Fragment extends BaseFragment {


    AttendanceInquiry1SVM svm;
    AttendanceInquiry1RVM rvm;
    FragmentAttendanceInquiry1Binding binding;
    private final CourseItemOnClickListener courseItemOnClickListener;

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
    protected void observerDataStateUpdateAction() {
        rvm.inquireCourseState.observe(this, aBoolean -> {
            if (!aBoolean) {
                Toast.makeText(getActivity(), "无课程", Toast.LENGTH_SHORT).show();
            }
            binding.smartRefreshLayout.finishRefresh();
        });
        rvm.courseList.observe(this, this::updateRV);
    }

    @Override
    protected void initView() {
        binding.smartRefreshLayout.setOnRefreshListener(refreshLayout -> rvm.inquireCourse());
    }

    @Override
    protected void getInternetData() {
        rvm.inquireCourse();
    }

    private void updateRV(List<InquireCourseBean.Message> data) {
        binding.rvCourse.setLayoutManager(new LinearLayoutManager(getActivity()));
        CourseInquireAttendanceAdapter adapter = new CourseInquireAttendanceAdapter(data);
        adapter.setCourseItemOnClickListener(courseItemOnClickListener);
        binding.rvCourse.setAdapter(adapter);
    }

    public class ClickClass {

    }
}