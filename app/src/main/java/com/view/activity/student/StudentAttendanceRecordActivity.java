package com.view.activity.student;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.adapter.student.AttendanceRecordAdapter;
import com.base.BaseActivity;
import com.response.retrofit_api.requstbody_bean.StudentID;
import com.response.retrofit_api.resposebody_bean.InquireAttendanceBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityStudentAttendanceRecordBinding;
import com.utils.ApplicationConfig;
import com.viewmodel.rvm.activity.student.StudentAttendanceRecordRVM;
import com.viewmodel.svm.activity.student.StudentAttendanceRecordSVM;

import java.util.List;

public class StudentAttendanceRecordActivity extends BaseActivity {

    ActivityStudentAttendanceRecordBinding binding;
    StudentAttendanceRecordSVM svm;
    StudentAttendanceRecordRVM rvm;
    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        svm=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(StudentAttendanceRecordSVM.class);
        rvm=new ViewModelProvider(this,new ViewModelProvider.NewInstanceFactory()).get(StudentAttendanceRecordRVM.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student__attendance_record);
        binding.setClick(new ClickClass());
        binding.setSvm(svm);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void initView() {
        binding.smartRefreshLayout.setOnRefreshListener(refreshLayout -> {
            StudentID studentID = new StudentID();
            studentID.setStudent_id(ApplicationConfig.userID);
            rvm.getAttendance(studentID);
        });
    }

    @Override
    protected void getInternetData() {
        StudentID studentID = new StudentID();
        studentID.setStudent_id(ApplicationConfig.userID);
        rvm.getAttendance(studentID);
    }

    @Override
    protected void observerDataStateUpdateAction() {
        rvm.requireState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if(!aBoolean){
                    Toast.makeText(StudentAttendanceRecordActivity.this, "网络错误", Toast.LENGTH_SHORT).show();
                }
                binding.smartRefreshLayout.finishRefresh();
            }
        });
        rvm.recordList.observe(this, new Observer<List<InquireAttendanceBean.Message>>() {
            @Override
            public void onChanged(List<InquireAttendanceBean.Message> messages) {
                updateRV(messages);
            }
        });
    }

    private void updateRV(List<InquireAttendanceBean.Message> list) {
        binding.attendanceRV.setLayoutManager(new LinearLayoutManager(this));
        binding.attendanceRV.setAdapter(new AttendanceRecordAdapter(list));
    }

    public class ClickClass{
        public void back(View view){
            finish();
        }
    }
}