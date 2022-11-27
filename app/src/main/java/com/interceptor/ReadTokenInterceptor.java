package com.interceptor;

import android.util.Log;

import com.response.db.SharedPreferencesManager;
import com.utils.ApplicationConfig;

import java.io.IOException;
import java.util.HashSet;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.Request;
import okhttp3.Response;

public class ReadTokenInterceptor implements Interceptor {
    @Override
    public Response intercept(Chain chain) throws IOException {
        Request.Builder builder = chain.request().newBuilder();
        HttpUrl httpUrl = chain.request().url();
        String urlString = httpUrl.toString();
        Log.d("ReadTokenInterceptor", "request to url:" + urlString);
        if (!urlString.startsWith(ApplicationConfig.baseUrl + "/user/captcha") &&
                !urlString.startsWith(ApplicationConfig.baseUrl + "/user/student_register") &&
                !urlString.startsWith(ApplicationConfig.baseUrl + "/user/student_login") &&
                !urlString.startsWith(ApplicationConfig.baseUrl + "/teacher/teacher_login") &&
                !urlString.startsWith(ApplicationConfig.baseUrl + "/teacher/teacher_register")) {
            String token = SharedPreferencesManager.getInstance().getToken();
            if (!token.equals("")) {
                builder.addHeader("Authorization", "Bearer " + token);
                Log.d("ReadTokenInterceptor", "And Header:" + "\"Authorization\":\"Bearer " + token + "\"");
            }
        }
        return chain.proceed(builder.build());
    }
}
