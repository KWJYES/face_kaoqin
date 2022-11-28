package com.view.fragment.teacher;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.base.BaseFragment;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.FragmentTeacherMineBinding;
import com.utils.ApplicationConfig;
import com.view.activity.teacher.AttendanceInquiryActivity;
import com.viewmodel.svm.fragment.teacher.TeacherMineSVM;


public class TeacherMineFragment extends BaseFragment {


    TeacherMineSVM svm;
    FragmentTeacherMineBinding binding;

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherMineSVM.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_teacher_mine, container, false);
        binding.setClick(new ClickClass());
        binding.setSvm(svm);
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    protected void initView() {
        svm.teacher_id.setValue(ApplicationConfig.userID);
        svm.teacher_name.setValue(ApplicationConfig.userName);
    }

    public class ClickClass{
        /**
         * 跳转考勤查询
         */
        public void attendanceInquiry(View view){
            startActivity(new Intent(getActivity(), AttendanceInquiryActivity.class));
        }
    }
}