// Tencent is pleased to support the open source community by making ncnn available.
//
// Copyright (C) 2021 THL A29 Limited, a Tencent company. All rights reserved.
//
// Licensed under the BSD 3-Clause License (the "License"); you may not use this file except
// in compliance with the License. You may obtain a copy of the License at
//
// https://opensource.org/licenses/BSD-3-Clause
//
// Unless required by applicable law or agreed to in writing, software distributed
// under the License is distributed on an "AS IS" BASIS, WITHOUT WARRANTIES OR
// CONDITIONS OF ANY KIND, either express or implied. See the License for the
// specific language governing permissions and limitations under the License.

package com.tencent.ncnnyoloface;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.PixelFormat;
import android.os.Bundle;
import android.os.Looper;
import android.text.format.DateFormat;
import android.util.Log;
import android.view.Gravity;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.baidu.ai.aip.utils.FaceSearch;
import com.baidu.ai.aip.utils.MyHelper;
import com.entity.EventBusMessage;
import com.response.retrofit_api.requstbody_bean.AttendanceBean;
import com.utils.ApplicationConfig;
import com.viewmodel.rvm.activity.teacher.AttendanceRVM;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Timer;
import java.util.TimerTask;


public class AttendanceActivity extends AppCompatActivity implements SurfaceHolder.Callback {
    public static final int REQUEST_CAMERA = 100;
    private NcnnYoloFace ncnnyoloface = new NcnnYoloFace();
    private int facing = 1;
    private Spinner spinnerModel;
    private Spinner spinnerCPUGPU;
    private int current_model = 0;
    private int current_cpugpu = 0;
    private ArrayList<String> list_img = new ArrayList<String>();
    private SurfaceView cameraView;
    public ArrayList<String> rg_face;
    public MyHelper db_test;

    private String course_id,course_time;//课号，第几大节
    AttendanceRVM rvm;
    private Calendar calendar;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        calendar = Calendar.getInstance();

        setContentView(R.layout.activity_attendance);
        rvm = new ViewModelProvider(this, new ViewModelProvider.NewInstanceFactory()).get(AttendanceRVM.class);
        observerDataStateUpdateAction();
        Intent intent=getIntent();
        course_id=intent.getStringExtra("course_id");
        course_time=intent.getStringExtra("course_time");
        EventBus.getDefault().register(this);//注册监听


        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
        cameraView = (SurfaceView) findViewById(R.id.cameraview);
        cameraView.getHolder().setFormat(PixelFormat.RGBA_8888);
        cameraView.getHolder().addCallback(this);
        //String token = AuthService.getAuth();
        db_test = new MyHelper(this);
        rg_face = new ArrayList<String>();
        Button buttonSwitchCamera = (Button) findViewById(R.id.buttonSwitchCamera);
        buttonSwitchCamera.setOnClickListener(arg0 -> {
            int new_facing = 1 - facing;
            ncnnyoloface.closeCamera();
            ncnnyoloface.openCamera(new_facing);
            facing = new_facing;
        });

        spinnerModel = (Spinner) findViewById(R.id.spinnerModel);
        spinnerModel.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                if (position != current_model) {
                    current_model = position;
                    reload();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        spinnerCPUGPU = (Spinner) findViewById(R.id.spinnerCPUGPU);
        spinnerCPUGPU.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> arg0, View arg1, int position, long id) {
                if (position != current_cpugpu) {
                    current_cpugpu = position;
                    reload();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> arg0) {
            }
        });

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                //TODO: 定时做某件事情
                list_img = ncnnyoloface.returnBase64();
                for (int i = 0; i < list_img.size(); i++) {
                    String face_log = FaceSearch.faceSearch(list_img.get(i), rg_face, db_test);
                    Log.i("2236", face_log);
                    if (face_log.equals("yes")) {
                        Looper.prepare();
                        Toast.makeText(AttendanceActivity.this, "识别成功", Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                }
                ncnnyoloface.setOne();
            }
        }, 3 * 1000, 3 * 1000);

        reload();
    }

    /**
     * 观察LiveData数据变化
     */
    private void observerDataStateUpdateAction() {
        rvm.attendanceState.observe(this, new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                Toast toast;
                if(aBoolean){
                    toast = Toast.makeText(AttendanceActivity.this, "打卡成功！", Toast.LENGTH_SHORT);
                }else {
                    toast = Toast.makeText(AttendanceActivity.this, "网络错误\n签到数据\n上传失败", Toast.LENGTH_SHORT);
                }
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });
    }

    /**
     * 接收EventBus数据
     *
     * @param message 传递来的消息
     */
    @Subscribe(threadMode = ThreadMode.MAIN)
    public void onEvent(EventBusMessage message){
        switch (message.msg){
            case ApplicationConfig.BAIDU_AI_USER_ID:
                AttendanceBean bean=new AttendanceBean();
                bean.setCourse_id(course_id);
                bean.setStudent_id(message.context);
                bean.setLesson_time(course_time);
                bean.setAttendance_time((String) DateFormat.format("yyy-MM-dd", calendar));
                rvm.attendance(bean);
                break;
        }
    }



    private void reload() {
        boolean ret_init = ncnnyoloface.loadModel(getAssets(), current_model, current_cpugpu);
        if (!ret_init) {
            Log.e("MainActivity", "ncnnyoloface loadModel failed");
        }
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        ncnnyoloface.setOutputWindow(holder.getSurface());
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
    }

    @Override
    public void onResume() {
        super.onResume();
        if (ContextCompat.checkSelfPermission(getApplicationContext(), Manifest.permission.CAMERA) == PackageManager.PERMISSION_DENIED) {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.CAMERA}, REQUEST_CAMERA);
        }
        ncnnyoloface.openCamera(facing);
    }

    @Override
    public void onPause() {
        super.onPause();
        ncnnyoloface.closeCamera();
    }


    @Override
    protected void onDestroy() {
        EventBus.getDefault().unregister(this);
        super.onDestroy();
    }
}
