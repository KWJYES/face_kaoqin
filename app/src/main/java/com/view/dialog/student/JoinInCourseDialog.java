package com.view.dialog.student;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.callback.JoinInCourseOnClickListener;
import com.response.retrofit_api.requstbody_bean.CourseID;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.DialogJoinInCourseBinding;
import com.utils.ApplicationConfig;

public class JoinInCourseDialog extends Dialog {

    DialogJoinInCourseBinding binding;
    private JoinInCourseOnClickListener joinInCourseOnClickListener;

    public JoinInCourseDialog(@NonNull Context context, JoinInCourseOnClickListener joinInCourseOnClickListener) {
        super(context);
        this.joinInCourseOnClickListener = joinInCourseOnClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_join_in_course, null, false);
        setContentView(binding.getRoot());
        binding.setClick(new ClickClass());
        initWindows();
    }

    public class ClickClass {
        public void joinInCourse(View view) {
            CourseID bean = new CourseID();
            if (binding.courseId.getText().toString().equals("")) {
                Toast.makeText(ApplicationConfig.getContext(), "输入不能为空！", Toast.LENGTH_SHORT).show();
                return;
            }
            bean.setCourse_id(binding.courseId.getText().toString());
            joinInCourseOnClickListener.joinInCourse(bean);
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
