package com.view.dialog.teacher;

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

import com.callback.CreateCourseOnClickListener;
import com.response.retrofit_api.requstbody_bean.CourseCreateBean;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.DialogCreateCourseBinding;
import com.utils.ApplicationConfig;


public class CreateCourseDialog extends Dialog {

    DialogCreateCourseBinding binding;
    private CreateCourseOnClickListener createCourseOnClickListener;


    public CreateCourseDialog(@NonNull Context context, CreateCourseOnClickListener createCourseOnClickListener) {
        super(context);
        this.createCourseOnClickListener = createCourseOnClickListener;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.inflate(LayoutInflater.from(getContext()), R.layout.dialog_create_course, null, false);
        setContentView(binding.getRoot());
        binding.setClick(new ClickClass());
        initWindows();
    }

    public class ClickClass{
        public void create(View view){
            String courseId=binding.courseId.getText().toString();
            String courseName=binding.courseName.getText().toString();
            if("".equals(courseId)||"".equals(courseName)) {
                Toast.makeText(ApplicationConfig.getContext(), "输入不能为空！", Toast.LENGTH_SHORT).show();
                return;
            }
            CourseCreateBean bean=new CourseCreateBean();
            bean.setCourse_id(courseId);
            bean.setCourse_name(courseName);
            createCourseOnClickListener.createCourse(bean);
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
