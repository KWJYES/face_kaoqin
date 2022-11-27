package com.view.activity.student;

import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.base.BaseActivity;
import com.entity.EventBusMessage;
import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.resposebody_bean.InquireCourseJoinBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityStudentCourseBinding;
import com.utils.ApplicationConfig;
import com.viewmodel.rvm.activity.student.StudentCourseRVM;
import com.viewmodel.svm.activity.student.StudentCourseSVM;

import org.greenrobot.eventbus.EventBus;

public class StudentCourseActivity extends BaseActivity {

    StudentCourseSVM svm;
    StudentCourseRVM rvm;
    ActivityStudentCourseBinding binding;

    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentCourseSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentCourseRVM.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_course);
        binding.setClick(new ClickClass());
        binding.setSvm(svm);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void observerDataStateUpdateAction() {
        rvm.quitCourseState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    EventBusMessage message = new EventBusMessage();
                    message.msg = ApplicationConfig.DELETE_COURSE;
                    EventBus.getDefault().post(message);
                    Toast.makeText(StudentCourseActivity.this, "已退出", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(StudentCourseActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    @Override
    protected void initView() {
        InquireCourseJoinBean.Message course = (InquireCourseJoinBean.Message) getIntent().getSerializableExtra("course");
        svm.course_id.setValue(course.getCourse_id());
        svm.student_id.setValue(course.getStudent_id());
        svm.course_name.setValue(course.getCourse_name());
    }

    public class ClickClass {
        /**
         * 退出课程
         *
         * @param view
         */
        public void deleteCourse(View view) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(StudentCourseActivity.this);
            dialog.setTitle("退出课程");
            dialog.setMessage("确定要退出 " + svm.course_id.getValue() + svm.course_name.getValue() + " 吗？");
            dialog.setCancelable(false);
            dialog.setPositiveButton("是的", (dialogInterface, i) -> {
                CourseID bean = new CourseID();
                bean.setCourse_id(svm.course_id.getValue());
                rvm.quitCourse(bean);
            });
            dialog.setNegativeButton("取消", (dialogInterface, i) -> {
            });
            dialog.show();
        }
    }
}