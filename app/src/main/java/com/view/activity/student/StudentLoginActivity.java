package com.view.activity.student;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.base.BaseActivity;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityStudentLoginBinding;
import com.utils.ActivityCollector;
import com.utils.InputChecker;
import com.view.activity.StartActivity;
import com.viewmodel.rvm.activity.student.StudentLoginRVM;
import com.viewmodel.svm.activity.student.StudentLoginSVM;

import java.util.Objects;

public class StudentLoginActivity extends BaseActivity {

    ActivityStudentLoginBinding binding;
    StudentLoginSVM svm;
    StudentLoginRVM rvm;

    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentLoginSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(StudentLoginRVM.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_student_login);
        binding.setClick(new ClickClass());
        binding.setSvm(svm);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void observerDataStateUpdateAction() {
        rvm.loginStatus.observe(this, aBoolean -> {
            if(aBoolean){
                Toast.makeText(StudentLoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(StudentLoginActivity.this,StudentMainActivity.class));
                finish();
                ActivityCollector.finishActivity(StartActivity.class);
            }else {
                Toast.makeText(StudentLoginActivity.this, "登陆失败！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ClickClass {
        /**
         * 进行登陆
         * @param view
         */
        public void login(View view){
            if(Objects.equals(svm.email.getValue(), "")|| Objects.equals(svm.password.getValue(), "")) return;
            if(!InputChecker.checkEmail(Objects.requireNonNull(svm.email.getValue()))){
                Toast.makeText(StudentLoginActivity.this, "邮箱格式错误", Toast.LENGTH_SHORT).show();
                return;
            }
            rvm.login(svm.email.getValue(),svm.password.getValue());
        }

        /**
         * 进入注册页面
         * @param view
         */
        public void register(View view){
            startActivity(new Intent(StudentLoginActivity.this,StudentRegisterActivity.class));
        }
    }
}