package com.view.dialog.teacher;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.callback.StartAttendanceDialogListener;
import com.response.retrofit_api.requstbody_bean.InputAttendanceRecordBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.DialogStartAttendanceBinding;

public class StartAttendanceDialog extends Dialog implements AdapterView.OnItemSelectedListener {
    private StartAttendanceDialogListener startAttendanceDialogListener;
    private InquireCourseBean.Message course;
    DialogStartAttendanceBinding binding;
    private String lesson_time="一";

    public StartAttendanceDialog(@NonNull Context context, InquireCourseBean.Message course, StartAttendanceDialogListener startAttendanceDialogListener) {
        super(context);
        this.startAttendanceDialogListener=startAttendanceDialogListener;
        this.course=course;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_start_attendance, null, false);
        setContentView(binding.getRoot());
        binding.setClick(new ClickClass());
        binding.setCourse(course);
        initSpinner();
        initWindows();
    }

    /**
     * 初始化Spinner，设置监听
     */
    private void initSpinner() {
        binding.spinner.setOnItemSelectedListener(this);
    }

    /**
     * 监听Spinner的选择事件
     * @param adapterView
     * @param view
     * @param i
     * @param l
     */
    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        lesson_time=adapterView.getItemAtPosition(i).toString();
    }

    /**
     * 监听Spinner的选择事件
     * @param adapterView
     */
    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {
        // TODO Auto-generated method stub
    }

    public class ClickClass{
        public void attendance(View view){
            InputAttendanceRecordBean bean=new InputAttendanceRecordBean();
            bean.setCourse_id(course.getId());
            bean.setLessons_time(lesson_time);
            startAttendanceDialogListener.attendance(bean);
        }
    }

    /**
     * 初始化对话框样式
     * 与显示位置
     */
    private void initWindows() {
        Window window = getWindow();
        assert window != null;
        window.setBackgroundDrawableResource(R.drawable.dialog_new_course);
        window.setGravity(Gravity.CENTER);//设置显示位置
    }
}
