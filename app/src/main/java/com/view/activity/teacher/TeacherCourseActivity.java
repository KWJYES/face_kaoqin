package com.view.activity.teacher;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AlertDialog;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.base.BaseActivity;
import com.callback.StartAttendanceDialogListener;
import com.entity.EventBusMessage;
import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.requstbody_bean.InputAttendanceRecordBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.tencent.ncnnyoloface.AttendanceActivity;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityTeacherCourseBinding;
import com.utils.ApplicationConfig;
import com.view.dialog.teacher.StartAttendanceDialog;
import com.viewmodel.rvm.activity.teacher.TeacherCourseRVM;
import com.viewmodel.svm.activity.teacher.TeacherCourseSVM;

import org.greenrobot.eventbus.EventBus;

public class TeacherCourseActivity extends BaseActivity {

    ActivityTeacherCourseBinding binding;
    TeacherCourseSVM svm;
    TeacherCourseRVM rvm;
    private StartAttendanceDialog dialog;

    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherCourseSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherCourseRVM.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_course);
        binding.setClick(new ClickClass());
        binding.setSvm(svm);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void initView() {
        InquireCourseBean.Message course = (InquireCourseBean.Message) getIntent().getSerializableExtra("course");
        svm.course.setValue(course);
        svm.course_id.setValue(course.getId());
        svm.course_name.setValue(course.getCourse_name());
        svm.teacher_id.setValue(course.getTeacher_id());
    }

    @Override
    protected void observerDataStateUpdateAction() {
        rvm.input_attendanceRecordState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Intent intent = new Intent(TeacherCourseActivity.this, AttendanceActivity.class);
                    intent.putExtra("course_id", svm.course_id.getValue());
                    intent.putExtra("course_time", svm.course_time.getValue());
                    startActivity(intent);
                    if (dialog.isShowing()) dialog.cancel();
                } else {
                    Toast.makeText(TeacherCourseActivity.this, "考勤请求失败", Toast.LENGTH_SHORT).show();
                }
            }
        });
        rvm.deleteCourseState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    EventBusMessage message = new EventBusMessage();
                    message.msg = ApplicationConfig.DELETE_COURSE;
                    EventBus.getDefault().post(message);
                    Toast.makeText(TeacherCourseActivity.this, "已删除", Toast.LENGTH_SHORT).show();
                    finish();
                } else {
                    Toast.makeText(TeacherCourseActivity.this, "网络异常", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    public class ClickClass {
        /**
         * 发起考勤
         *
         * @param view
         */
        public void attendance(View view) {
            dialog = new StartAttendanceDialog(TeacherCourseActivity.this, svm.course.getValue(), new StartAttendanceDialogListener() {
                @Override
                public void attendance(InputAttendanceRecordBean bean) {
                    svm.course_time.setValue(bean.getLessons_time());
                    rvm.inputAttendanceRecord(bean);
                }
            });
            dialog.show();
        }

        /**
         * 删除课号
         *
         * @param view
         */
        public void deleteCourse(View view) {
            AlertDialog.Builder dialog = new AlertDialog.Builder(TeacherCourseActivity.this);
            dialog.setTitle("删除课程");
            dialog.setMessage("确定要删除 " + svm.course_id.getValue() + svm.course_name.getValue() + " 吗？");
            dialog.setCancelable(false);
            dialog.setPositiveButton("是的", (dialogInterface, i) -> {
                CourseID bean = new CourseID();
                bean.setCourse_id(svm.course_id.getValue());
                rvm.deleteCourse(bean);
            });
            dialog.setNegativeButton("取消", (dialogInterface, i) -> {
            });
            dialog.show();
        }
    }
}