package com.view.fragment.student;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.base.BaseFragment;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.FragmentMineBinding;
import com.utils.ApplicationConfig;
import com.view.activity.student.StudentAttendanceRecordActivity;
import com.viewmodel.rvm.fragment.student.StudentMineRVM;
import com.viewmodel.svm.fragment.student.StudentMineSVM;

public class StudentMineFragment extends BaseFragment {

    FragmentMineBinding binding;
    StudentMineSVM svm;
    StudentMineRVM rvm;

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentMineSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentMineRVM.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_mine, container, false);
        binding.setSvm(svm);
        binding.setClick(new ClickClass());
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    protected void initView() {
        svm.student_id.setValue(ApplicationConfig.userID);
        svm.student_name.setValue(ApplicationConfig.userName);
    }

    public class ClickClass {
        public void myAttendance(View view) {
            startActivity(new Intent(getActivity(), StudentAttendanceRecordActivity.class));
        }
    }
}