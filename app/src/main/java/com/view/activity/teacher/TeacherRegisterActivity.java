package com.view.activity.teacher;

import android.view.View;
import android.widget.Toast;

import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.base.BaseActivity;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityTeacherRegisterBinding;
import com.utils.InputChecker;
import com.viewmodel.rvm.activity.teacher.TeacherRegisterRVM;
import com.viewmodel.svm.activity.teacher.TeacherRegisterSVM;

import java.util.Objects;

public class TeacherRegisterActivity extends BaseActivity {

    ActivityTeacherRegisterBinding binding;
    TeacherRegisterSVM svm;
    TeacherRegisterRVM rvm;

    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        svm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherRegisterSVM.class);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(TeacherRegisterRVM.class);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_teacher_register);
        binding.setClick(new ClickClass());
        binding.setSvm(svm);
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void observerDataStateUpdateAction() {
        rvm.getCaptchaStatus.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean)
                    Toast.makeText(TeacherRegisterActivity.this, "验证码已发送", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(TeacherRegisterActivity.this, "获取验证码失败", Toast.LENGTH_SHORT).show();
            }
        });
        rvm.registerStatus.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                if (aBoolean) {
                    Toast.makeText(TeacherRegisterActivity.this, "注册成功！", Toast.LENGTH_SHORT).show();
                    finish();
                }
                else Toast.makeText(TeacherRegisterActivity.this, "注册失败！", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public class ClickClass {
        /**
         * 获取验证码
         *
         * @param view
         */
        public void getCaptcha(View view) {
            if (Objects.equals(svm.email.getValue(), "")) {
                Toast.makeText(TeacherRegisterActivity.this, "请先填写邮箱", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!InputChecker.checkEmail(Objects.requireNonNull(svm.email.getValue()))){
                Toast.makeText(TeacherRegisterActivity.this, "邮箱格式错误", Toast.LENGTH_SHORT).show();
                return;
            }
            rvm.getCaptcha(svm.email.getValue());
        }

        /**
         * 进行注册
         *
         * @param view
         */
        public void register(View view) {
            if (Objects.equals(svm.email.getValue(), "") ||
                    Objects.equals(svm.captcha.getValue(), "") ||
                    Objects.equals(svm.username.getValue(), "") ||
                    Objects.equals(svm.student_id.getValue(), "") ||
                    Objects.equals(svm.password.getValue(), "") ||
                    Objects.equals(svm.password_confirm.getValue(), "")) {
                Toast.makeText(TeacherRegisterActivity.this, "请先完善您的注册信息", Toast.LENGTH_SHORT).show();
                return;
            }
            if (!InputChecker.checkStudentID(Objects.requireNonNull(svm.student_id.getValue()))) {
                Toast.makeText(TeacherRegisterActivity.this, "昵称非法", Toast.LENGTH_SHORT).show();
                return;
            }
            if(!InputChecker.checkEmail(Objects.requireNonNull(svm.email.getValue()))){
                Toast.makeText(TeacherRegisterActivity.this, "邮箱格式错误", Toast.LENGTH_SHORT).show();
                return;
            }
            rvm.register(svm.email.getValue(),
                    svm.captcha.getValue(),
                    svm.username.getValue(),
                    svm.student_id.getValue(),
                    svm.password.getValue(),
                    svm.password_confirm.getValue());
        }
    }
}