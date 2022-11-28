package com.view.activity.teacher;

import android.view.KeyEvent;
import android.view.View;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.base.BaseActivity;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityAttendanceInquiryBinding;
import com.view.fragment.teacher.AttendanceInquiry1Fragment;
import com.view.fragment.teacher.AttendanceInquiry2Fragment;

public class AttendanceInquiryActivity extends BaseActivity {

    ActivityAttendanceInquiryBinding binding;
    private FragmentManager fragmentManager;

    @Override
    protected void initActivity() {
        setTransparentStatusBar(true);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_attendance_inquiry);
        binding.setClick(new ClickClass());
        binding.setLifecycleOwner(this);
    }

    @Override
    protected void initView() {
        replaceFragment(new AttendanceInquiry1Fragment(course -> replaceFragment(new AttendanceInquiry2Fragment(course))));
    }

    public class ClickClass {
        public void back(View view) {
            finish();
        }
    }

    /**
     * 通过getSupportFragmentManager()获得FragmentManager对象
     * 通过调用beginTransaction()方法开启一个事务
     * 向容器添加或替换碎片，一般用replace()方法实现，需要传入容器的id和待添加的碎片实例
     * 调用commit()方法来提交事务
     *
     * @param fragment
     */
    public void replaceFragment(Fragment fragment) {
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.replace(R.id.fragment, fragment);
        transaction.addToBackStack(null);//碎片模拟返回栈
        transaction.commit();
    }

    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {
            if (fragmentManager.getBackStackEntryCount() <= 1) finish();
            else onBackPressed();
            return true;
        }
        return super.onKeyUp(keyCode, event);
    }
}