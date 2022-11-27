package com.response.db;

public interface ISharedPreferencesRequest {
    /**
     * 保存后端返回的token
     * @param token 后端返回的token
     */
    void saveToken(String token);

    /**
     * 保存后端返回的refresh_token
     * @param refresh_token 后端返回的refresh_token
     */
    void saveRefreshToken(String refresh_token);

    /**
     * 从本地拿已保存的token
     * @return 已保存的token
     */
    String getToken();

    /**
     * 从本地拿已保存的refresh_token
     * @return 已保存的refresh_token
     */
    String getRefreshToken();
}
