package com.view.fragment.teacher;

import android.app.DatePickerDialog;
import android.os.Bundle;
import android.text.format.DateFormat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.adapter.teacher.InquireAttendanceAdapter;
import com.base.BaseFragment;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.response.retrofit_api.resposebody_bean.TeacherInquireAttendanceBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.FragmentAttendanceInquiry2Binding;
import com.viewmodel.rvm.fragment.teacher.AttendanceInquiry2RVM;
import com.viewmodel.svm.fragment.teacher.AttendanceInquiry2SVM;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.Objects;

public class AttendanceInquiry2Fragment extends BaseFragment {
    private InquireCourseBean.Message course;
    AttendanceInquiry2SVM svm;
    AttendanceInquiry2RVM rvm;
    FragmentAttendanceInquiry2Binding binding;
    private Calendar calendar;
    private DatePickerDialog dialog;

    public AttendanceInquiry2Fragment(InquireCourseBean.Message course) {
        this.course = course;
    }

    @Override
    protected View initFragment(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AttendanceInquiry2SVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AttendanceInquiry2RVM.class);
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_attendance_inquiry2, container, false);
        binding.setSvm(svm);
        binding.setClick(new ClickClass());
        binding.setLifecycleOwner(this);
        return binding.getRoot();
    }

    @Override
    protected void initView() {
        initDateDialog();
        initSpinner();
        svm.dateString.setValue((String) DateFormat.format("yyy-MM-dd", calendar));
        svm.lessonTime.setValue("一");
        //rvm.inquireAttendance(course.getId(), svm.dateString.getValue(),svm.lessonTime.getValue());
    }

    @Override
    protected void observerDataStateUpdateAction() {
        rvm.requestState.observe(this, aBoolean -> {
            if(aBoolean){
                binding.blankBox.setVisibility(View.GONE);
            }else {
                binding.blankBox.setVisibility(View.VISIBLE);
                updateRV(new ArrayList<>());
            }
        });
        rvm.list.observe(this, this::updateRV);
    }

    private void updateRV(List<TeacherInquireAttendanceBean.Message> messages) {
        if(messages.size()==0)
            binding.blankBox.setVisibility(View.VISIBLE);
        else
            binding.blankBox.setVisibility(View.GONE);
        binding.rvAttendance.setLayoutManager(new LinearLayoutManager(getActivity()));
        binding.rvAttendance.setAdapter(new InquireAttendanceAdapter(messages));
    }

    private void initDateDialog() {
        calendar = Calendar.getInstance();
        dialog = new DatePickerDialog(Objects.requireNonNull(getActivity()), (view, year, monthOfYear, dayOfMonth) -> {
            calendar.set(year, monthOfYear, dayOfMonth);
            svm.dateString.setValue((String) DateFormat.format("yyy-MM-dd", calendar));
            rvm.inquireAttendance(course.getId(), svm.dateString.getValue(),svm.lessonTime.getValue());
        }, calendar.get(Calendar.YEAR), calendar.get(Calendar.MONTH), calendar.get(Calendar.DAY_OF_MONTH));
    }

    private void initSpinner() {
        binding.spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                svm.lessonTime.setValue(adapterView.getItemAtPosition(i).toString());
                rvm.inquireAttendance(course.getId(), svm.dateString.getValue(),svm.lessonTime.getValue());
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }

    public class ClickClass {
        public void showDataDialog(View view) {
            dialog.show();
        }
        public void backFragment(View view){
            Objects.requireNonNull(getActivity()).onBackPressed();
        }
    }


}