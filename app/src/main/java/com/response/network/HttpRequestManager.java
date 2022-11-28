package com.response.network;

import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.google.gson.Gson;
import com.interceptor.ReadTokenInterceptor;
import com.response.db.SharedPreferencesManager;
import com.response.retrofit_api.IPublicService;
import com.response.retrofit_api.IStudentService;
import com.response.retrofit_api.ITeacherService;
import com.response.retrofit_api.requstbody_bean.AttendanceBean;
import com.response.retrofit_api.requstbody_bean.CheckCourseExistBean;
import com.response.retrofit_api.requstbody_bean.CourseCreateBean;
import com.response.retrofit_api.requstbody_bean.CourseID;
import com.response.retrofit_api.requstbody_bean.InputAttendanceRecordBean;
import com.response.retrofit_api.requstbody_bean.StudentID;
import com.response.retrofit_api.resposebody_bean.InquireAttendanceBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseBean;
import com.response.retrofit_api.resposebody_bean.InquireCourseJoinBean;
import com.response.retrofit_api.resposebody_bean.JoinInCourseSucceed;
import com.response.retrofit_api.resposebody_bean.TeacherInquireAttendanceBean;
import com.utils.ApplicationConfig;
import com.utils.JWTUtil;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import okhttp3.OkHttpClient;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class HttpRequestManager implements IStudentNetworkRequest, ITeacherNetworkRequest, IPublicNetworkRequest {

    private static Retrofit retrofit;
    private static IStudentService studentService;
    private static ITeacherService teacherService;
    private static IPublicService publicService;
    private static Gson gson;

    /**
     * 使用单例模式
     */
    private HttpRequestManager() {

        OkHttpClient okHttpClient = new OkHttpClient.Builder()
//                    .addInterceptor(new SaveTokenInterceptor())
                .addInterceptor(new ReadTokenInterceptor())
                .build();
        retrofit = new Retrofit.Builder()
                .client(okHttpClient)
                .baseUrl(ApplicationConfig.baseUrl)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        studentService = retrofit.create(IStudentService.class);
        teacherService = retrofit.create(ITeacherService.class);
        publicService = retrofit.create(IPublicService.class);
        gson = new Gson();
    }

    private static HttpRequestManager httpRequestManager;

    public static HttpRequestManager getInstance() {
        if (httpRequestManager == null) {
            synchronized (HttpRequestManager.class) {
                if (null == httpRequestManager) {
                    httpRequestManager = new HttpRequestManager();
                }
            }
        }
        return httpRequestManager;
    }

    @Override
    public void attendanceRecord(AttendanceBean bean, MutableLiveData<Boolean> requestState) {
        teacherService.attendance_record(bean).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        int code = jsonObject.getInt("code");
                        if (code != 200) {
                            Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            Log.d("HttpRequestManager", "attendanceRecord code=" + code);
                            Log.d("HttpRequestManager", "body = " +bean.toString());
                            Log.d("HttpRequestManager", jsonObject.toString());
                            return;
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                    requestState.setValue(true);
                } else {
                    Log.d("HttpRequestManager", "response.code()=" + response.code());
                    requestState.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, @NonNull Throwable t) {
                requestState.setValue(false);
                Log.d("HttpRequestManager", "签到数据上传失败:" + t);
            }
        });
    }

    @Override
    public void teacherRegister(String email, String captcha, String username, String student_id, String password, String password_confirm, MutableLiveData<Boolean> state) {
        teacherService.register(email, captcha, username, student_id, password, password_confirm).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        int code = jsonObject.getInt("code");
                        if (code != 200) {
                            Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            Log.d("HttpRequestManager", "teacherRegister code=" + code);
                            Log.d("HttpRequestManager", jsonObject.toString());
                            return;
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                    state.setValue(true);
                } else {
                    Log.d("HttpRequestManager", "response.code()=" + response.code());
                    state.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, @NonNull Throwable t) {
                state.setValue(false);
                Log.d("HttpRequestManager", "注册失败:" + t);
            }
        });
    }

    @Override
    public void teacherLogin(String email, String password, MutableLiveData<Boolean> state) {
        teacherService.login(email, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        try {
                            int code = jsonObject.getInt("code");
                            if (code != 200) {
                                Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                Log.d("HttpRequestManager", "login code=" + code);
                                Log.d("HttpRequestManager", jsonObject.toString());
                                Log.d("HttpRequestManager", "email=" + email);
                                Log.d("HttpRequestManager", "password=" + password);
                                return;
                            }
                            String refresh_token = jsonObject.getString("refresh_token");
                            SharedPreferencesManager.getInstance().saveRefreshToken(refresh_token);
                            String token = jsonObject.getString("token");
                            SharedPreferencesManager.getInstance().saveToken(token);
                            String jwtJson = JWTUtil.JWTParse(token);
                            JSONObject jwtJO = new JSONObject(jwtJson);
                            ApplicationConfig.userID = jwtJO.getString("user_id");
                            Log.d("HttpRequestManager", "user_id=" + ApplicationConfig.userID);
                        } catch (JSONException e) {
                            e.printStackTrace();

                        }
                        ApplicationConfig.userName = jsonObject.getString("user_name");
                        Log.d("HttpRequestManager", "userName=" + ApplicationConfig.userName);
                        state.setValue(true);
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                        state.setValue(false);
                        Log.d("HttpRequestManager", "token is null");
                    }
                } else {
                    Log.d("HttpRequestManager", "response.code()=" + response.code());
                    state.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, @NonNull Throwable t) {
                Log.d("HttpRequestManager", "登陆失败:" + t);
                state.setValue(false);
            }
        });
    }

    @Override
    public void createCourse(CourseCreateBean bean, MutableLiveData<Boolean> state) {
        teacherService.createCourse(bean).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    assert response.body() != null;
                    String json = response.body().string();
                    JSONObject jsonObject = new JSONObject(json);
                    int code = jsonObject.getInt("code");
                    if (code != 200) {
                        Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        Log.d("HttpRequestManager", "createCourse code=" + code);
                        Log.d("HttpRequestManager", jsonObject.toString());
                        return;
                    }
                    state.setValue(true);
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                state.setValue(false);
            }
        });
    }

    @Override
    public void checkCourseExist(CheckCourseExistBean bean, MutableLiveData<String> msg, MutableLiveData<Boolean> state) {
        teacherService.checkCourseExist(bean).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                try {
                    assert response.body() != null;
                    String json = response.body().string();
                    JSONObject jsonObject = new JSONObject(json);
                    int code = jsonObject.getInt("code");
                    if (code != 200) {
                        Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                        Log.d("HttpRequestManager", "checkCourseExist code=" + code);
                        Log.d("HttpRequestManager", jsonObject.toString());
                        return;
                    }
                    String message = jsonObject.getString("message");
                    msg.setValue(message);
                } catch (JSONException | IOException e) {
                    e.printStackTrace();
                }
                state.setValue(true);
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                state.setValue(false);
            }
        });
    }

    @Override
    public void inquireCourse(MutableLiveData<List<InquireCourseBean.Message>> data, MutableLiveData<Boolean> state) {
        teacherService.inquireCourse().enqueue(new Callback<InquireCourseBean>() {
            @Override
            public void onResponse(Call<InquireCourseBean> call, @NonNull Response<InquireCourseBean> response) {
                InquireCourseBean bean = response.body();
                assert bean != null;
                Log.d("HttpRequestManager", "老师所有课程: " + bean.getMessage().size() + "门");
                for (InquireCourseBean.Message course : bean.getMessage()) {
                    Log.d("HttpRequestManager", course.getId() + " " + course.getCourse_name());
                }
                data.setValue(bean.getMessage());
                state.setValue(true);
            }

            @Override
            public void onFailure(Call<InquireCourseBean> call, Throwable t) {
                state.setValue(false);
            }
        });
    }

    @Override
    public void inputAttendanceRecord(MutableLiveData<Boolean> state, InputAttendanceRecordBean bean) {
        teacherService.inputAttendanceRecord(bean).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        int code = jsonObject.getInt("code");
                        if (code != 200) {
                            Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            Log.d("HttpRequestManager", "inputAttendanceRecord code=" + code);
                            Log.d("HttpRequestManager", jsonObject.toString());
                            return;
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                    Log.d("HttpRequestManager", "添加发起的考勤进入数据库 成功");
                    state.setValue(true);
                } else {
                    Log.d("HttpRequestManager", "response.code()=" + response.code());
                    state.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                state.setValue(false);
                Log.d("HttpRequestManager", "请求失败");
            }
        });
    }

    @Override
    public void teacherInquire_attendance(com.response.retrofit_api.requstbody_bean.InquireAttendanceBean inquireAttendanceBean, MutableLiveData<List<TeacherInquireAttendanceBean.Message>> list, MutableLiveData<Boolean> state) {
        teacherService.teacherInquire_attendance(inquireAttendanceBean).enqueue(new Callback<TeacherInquireAttendanceBean>() {
            @Override
            public void onResponse(Call<TeacherInquireAttendanceBean> call, Response<TeacherInquireAttendanceBean> response) {
                TeacherInquireAttendanceBean bean=response.body();
                if(bean==null||bean.getMessage()==null){
                    list.setValue(new ArrayList<>());
                }else {
                    list.setValue(bean.getMessage());
                }
                state.setValue(true);
            }

            @Override
            public void onFailure(Call<TeacherInquireAttendanceBean> call, Throwable t) {
                state.setValue(false);
            }
        });
    }

    @Override
    public void studentRegister(String email, String captcha, String username, String student_id, String password, String password_confirm, MutableLiveData<Boolean> state) {
        studentService.register(email, captcha, username, student_id, password, password_confirm).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        int code = jsonObject.getInt("code");
                        if (code != 200) {
                            Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            Log.d("HttpRequestManager", "Register code=" + code);
                            Log.d("HttpRequestManager", jsonObject.toString());
                            return;
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                    state.setValue(true);
                } else {
                    Log.d("HttpRequestManager", "response.code()=" + response.code());
                    state.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, @NonNull Throwable t) {
                state.setValue(false);
                Log.d("HttpRequestManager", "注册失败:" + t);
            }
        });
    }

    @Override
    public void getCaptcha(String email, MutableLiveData<Boolean> state) {
        publicService.getCaptcha(email).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        int code = jsonObject.getInt("code");
                        if (code != 200) {
                            Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            Log.d("HttpRequestManager", "getCaptcha code=" + code);
                            Log.d("HttpRequestManager", jsonObject.toString());
                            return;
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                    state.setValue(true);
                } else {
                    Log.d("HttpRequestManager", "response.code()=" + response.code());
                    state.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, @NonNull Throwable t) {
                state.setValue(false);
                Log.d("HttpRequestManager", "获取验证码失败:" + t);
            }
        });
    }

    @Override
    public void studentLogin(String email, String password, MutableLiveData<Boolean> state) {
        studentService.login(email, password).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, @NonNull Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        try {
                            int code = jsonObject.getInt("code");
                            if (code != 200) {
                                Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                Log.d("HttpRequestManager", "login code=" + code);
                                Log.d("HttpRequestManager", jsonObject.toString());
                                Log.d("HttpRequestManager", "email=" + email);
                                Log.d("HttpRequestManager", "password=" + password);
                                return;
                            }
                            String refresh_token = jsonObject.getString("refresh_token");
                            SharedPreferencesManager.getInstance().saveRefreshToken(refresh_token);
                            String token = jsonObject.getString("token");
                            SharedPreferencesManager.getInstance().saveToken(token);
                            String jwtJson = JWTUtil.JWTParse(token);
                            JSONObject jwtJO = new JSONObject(jwtJson);
                            ApplicationConfig.userID = jwtJO.getString("user_id");
                            Log.d("HttpRequestManager", "user_id=" + ApplicationConfig.userID);
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        ApplicationConfig.userName = jsonObject.getString("user_name");
                        Log.d("HttpRequestManager", "userName=" + ApplicationConfig.userName);
                        state.setValue(true);
                    } catch (IOException | JSONException e) {
                        e.printStackTrace();
                        state.setValue(false);
                        Log.d("HttpRequestManager", "token is null");
                    }
                } else {
                    Log.d("HttpRequestManager", "response.code()=" + response.code());
                    state.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, @NonNull Throwable t) {
                state.setValue(false);
                Log.d("HttpRequestManager", "登陆失败:" + t);
            }
        });
    }

    @Override
    public void inquireCourseJoinCourse(MutableLiveData<Boolean> state, MutableLiveData<List<InquireCourseJoinBean.Message>> data) {
        studentService.inquireCourseJoinBean().enqueue(new Callback<InquireCourseJoinBean>() {
            @Override
            public void onResponse(Call<InquireCourseJoinBean> call, Response<InquireCourseJoinBean> response) {
                InquireCourseJoinBean bean = response.body();
                if(bean==null){
                    state.setValue(false);
                    return;
                }
                Log.d("HttpRequestManager", "加入的所有课程: " + bean.getMessage().size() + "门");
                for (InquireCourseJoinBean.Message course : bean.getMessage()) {
                    Log.d("HttpRequestManager", course.getCourse_id() + " " + course.getCourse_name());
                }
                data.setValue(bean.getMessage());
                state.setValue(true);
            }

            @Override
            public void onFailure(Call<InquireCourseJoinBean> call, Throwable t) {
                state.setValue(false);
            }
        });
    }

    @Override
    public void joinCourse(CourseID body, MutableLiveData<Boolean> state) {
        studentService.joinCourse(body).enqueue(new Callback<JoinInCourseSucceed>() {
            @Override
            public void onResponse(Call<JoinInCourseSucceed> call, Response<JoinInCourseSucceed> response) {
                JoinInCourseSucceed bean = response.body();
                if(bean==null){
                    state.setValue(false);
                    return;
                }
                state.setValue(true);
            }

            @Override
            public void onFailure(Call<JoinInCourseSucceed> call, Throwable t) {
                state.setValue(false);
            }
        });
    }

    @Override
    public void quitCourse(CourseID body, MutableLiveData<Boolean> state) {
        studentService.quitCourse(body).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.code() == 200) {
                    try {
                        assert response.body() != null;
                        String json = response.body().string();
                        JSONObject jsonObject = new JSONObject(json);
                        int code = jsonObject.getInt("code");
                        if (code != 200) {
                            Toast.makeText(ApplicationConfig.getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                            Log.d("HttpRequestManager", "getCaptcha code=" + code);
                            Log.d("HttpRequestManager", jsonObject.toString());
                            return;
                        }
                    } catch (JSONException | IOException e) {
                        e.printStackTrace();
                    }
                    state.setValue(true);
                } else {
                    Log.d("HttpRequestManager", "response.code()=" + response.code());
                    state.setValue(false);
                }
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                state.setValue(false);
            }
        });
    }

    @Override
    public void studentInquireAttendance(StudentID body, MutableLiveData<List<InquireAttendanceBean.Message>> recordList, MutableLiveData<Boolean> state) {
        studentService.inquireAttendance(body).enqueue(new Callback<InquireAttendanceBean>() {
            @Override
            public void onResponse(Call<InquireAttendanceBean> call, Response<InquireAttendanceBean> response) {
                InquireAttendanceBean inquireAttendanceBean=response.body();
                if(inquireAttendanceBean==null){
                    recordList.setValue(new ArrayList<>());
                    state.setValue(true);
                    return;
                }
                recordList.setValue((inquireAttendanceBean.getMessage()==null)?(new ArrayList<>()):inquireAttendanceBean.getMessage());
                state.setValue(true);
            }

            @Override
            public void onFailure(Call<InquireAttendanceBean> call, Throwable t) {
                state.setValue(false);
            }
        });
    }
}
