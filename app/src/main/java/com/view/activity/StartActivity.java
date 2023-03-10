package com.view.activity;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;

import com.base.BaseActivity;
import com.tencent.ncnnyoloface.R;
import com.tencent.ncnnyoloface.databinding.ActivityStartBinding;
import com.utils.PermissionUtil;
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

    @Override
    protected void initView() {
        PermissionUtil.getInstance().checkPermission(StartActivity.this, this, PermissionUtil.READ_EXTERNAL_STORAGE, Manifest.permission.READ_EXTERNAL_STORAGE, Manifest.permission.WRITE_EXTERNAL_STORAGE);
        PermissionUtil.getInstance().checkPermission(StartActivity.this, this, PermissionUtil.CAMERA, Manifest.permission.CAMERA);
    }

    /**
     * 处理权限请求结果
     *
     * @param requestCode  The request code passed in {@link # requestPermissions(
     *                     android.app.Activity, String[], int)}
     * @param permissions  The requested permissions. Never null.
     * @param grantResults The grant results for the corresponding permissions
     *                     which is either {@link android.content.pm.PackageManager#PERMISSION_GRANTED}
     *                     or {@link android.content.pm.PackageManager#PERMISSION_DENIED}. Never null.
     */
    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        switch (requestCode) {
            case PermissionUtil.WRITE_EXTERNAL_STORAGE:
            case PermissionUtil.READ_EXTERNAL_STORAGE:
            case PermissionUtil.CAMERA:
                if (grantResults.length <= 0 || grantResults[0] != PackageManager.PERMISSION_GRANTED) {
                    Toast.makeText(StartActivity.this, "您拒绝了相关权限", Toast.LENGTH_SHORT).show();
                    finish();
                }
                break;
        }
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