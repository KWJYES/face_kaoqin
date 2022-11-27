package com.utils;

import android.annotation.SuppressLint;
import android.content.Context;

public class ApplicationConfig {
    public static String userName="";
    public static String userID="";

    public static final String baseUrl="http://47.113.203.151:5000";

    //EventBus的数据来源分类
    public static final int BAIDU_AI_USER_ID=0;//签到时，人脸库匹配到对应人脸返回的的user_id
    public static final int DELETE_COURSE=1;//学生退出课程，或老师删除课程


    @SuppressLint("StaticFieldLeak")
    public static Context loginContext;
    @SuppressLint("StaticFieldLeak")
    public static Context registerContext;
    @SuppressLint("StaticFieldLeak")
    public static Context mainContext;

    public static Context getContext(){
        if(mainContext!=null) return mainContext;
        if(loginContext!=null) return loginContext;
        if(registerContext!=null) return registerContext;
        return null;
    }
}
