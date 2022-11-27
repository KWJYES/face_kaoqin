package com.view.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.base.BaseActivity;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityStartBinding;
import com.view.activity.student.StudentLoginActivity;
import com.view.activity.teacher.TeacherLoginActivity;

public class StartActivity extends BaseActivity {

    ActivityStartBinding binding;

    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_start);
        binding.setClick(new CLickClass());
        binding.setLifecycleOwner(this);
    }

    public class CLickClass{
        /**
         * “点击我是学生”
         * @param view
         */
        public void studentBtn(View view){
            startActivity(new Intent(StartActivity.this, StudentLoginActivity.class));
        }

        /**
         * “点击我是老师”
         * @param view
         */
        public void teacherBtn(View view){
            startActivity(new Intent(StartActivity.this, TeacherLoginActivity.class));
        }
    }
}