package com.view.activity.teacher;

import android.content.Intent;
import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.ViewModelProvider;

import com.base.BaseActivity;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityTeacherLoginBinding;
import com.utils.ActivityCollector;
import com.utils.InputChecker;
import com.view.activity.StartActivity;
import com.viewmodel.rvm.activity.teacher.TeacherLoginRVM;
import com.viewmodel.svm.activity.teacher.TeacherLoginSVM;

import java.util.Objects;

public class TeacherLoginActivity extends BaseActivity {

    ActivityTeacherLoginBinding binding;
    TeacherLoginSVM svm;
    TeacherLoginRVM rvm;


    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherLoginSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherLoginRVM.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_login);
        binding.setClick(new ClickClass());
        binding.setSvm(svm);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void observerDataStateUpdateAction() {
        rvm.loginStatus.observe(this, aBoolean -> {
            if(aBoolean){
                Toast.makeText(TeacherLoginActivity.this, "登陆成功！", Toast.LENGTH_SHORT).show();
                startActivity(new Intent(TeacherLoginActivity.this,TeacherMainActivity.class));
                ActivityCollector.finishActivity(StartActivity.class);
                finish();
            }else {
                Toast.makeText(TeacherLoginActivity.this, "登陆失败！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ClickClass{
        /**
         * 进行登陆
         * @param view
         */
        public void login(View view){
            if (svm.email.getValue() == null || svm.email.getValue().equals("") || svm.password.getValue() == null || svm.password.getValue().equals(""))
                return;
            if(!InputChecker.checkEmail(Objects.requireNonNull(svm.email.getValue()))){
                Toast.makeText(TeacherLoginActivity.this, "邮箱格式错误", Toast.LENGTH_SHORT).show();
                return;
            }
            rvm.login(svm.email.getValue(),svm.password.getValue());
        }

        /**
         * 进入注册页面
         * @param view
         */
        public void register(View view){
            startActivity(new Intent(TeacherLoginActivity.this, TeacherRegisterActivity.class));
        }
    }
}