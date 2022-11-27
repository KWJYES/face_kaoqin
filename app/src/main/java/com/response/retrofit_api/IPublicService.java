package com.response.retrofit_api;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface IPublicService {

    /**
     * 获取验证码
     * @param email
     * @return
     */
    @FormUrlEncoded
    @POST("/user/captcha")
    Call<ResponseBody> getCaptcha(@Field("email") String email);
}
