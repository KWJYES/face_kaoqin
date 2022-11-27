package com.response.network;

import androidx.lifecycle.MutableLiveData;

public interface IPublicNetworkRequest {
    /**
     *  @param email 邮箱
     * @param state 网络请求状态
     */
    void getCaptcha(String email, MutableLiveData<Boolean> state);
}
