package com.tencent.ncnnyoloface;

import android.Manifest;

import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Build;


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class SelectActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btn_change,btn_opt,btn_register,btn_delete,btn_out;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select);

        initView();
        readRequest();
    }

    private void initView() {
        btn_change=findViewById(R.id.change);
        btn_change.setOnClickListener(this);

        btn_register=findViewById(R.id.register);
        btn_register.setOnClickListener(this);

        btn_opt=findViewById(R.id.face_rg);
        btn_opt.setOnClickListener(this);

        btn_delete=findViewById(R.id.delete);
        btn_delete.setOnClickListener(this);

        btn_out=findViewById(R.id.out);
        btn_out.setOnClickListener(this);
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==R.id.change){
            Intent in=new Intent(this, SearchDataActivity.class);
            startActivity(in);
        }
        else if(v.getId()==R.id.register){
            Intent in=new Intent(this, RegisterActivity.class);
            startActivity(in);
        }else  if(v.getId()==R.id.face_rg){
            Intent in=new Intent(this, AttendanceActivity.class);
            startActivity(in);
        }else if(v.getId()==R.id.delete){
            Intent in=new Intent(this, DeleteInfoActivity.class);
            startActivity(in);
        }else{
            System system = null;
            system.exit(0);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.M)
    void readRequest() {             //获取相机拍摄读写权限
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            if (checkSelfPermission(Manifest.permission.READ_EXTERNAL_STORAGE) != PackageManager.PERMISSION_GRANTED) {
                ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.READ_EXTERNAL_STORAGE,
                        Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA}, 1);
            }
        }
    }
}