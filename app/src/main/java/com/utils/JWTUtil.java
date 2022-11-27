package com.utils;

import android.util.Base64;

import java.io.UnsupportedEncodingException;

public class JWTUtil {
    /**
     * 解析jwtToken中的信息
     * @param jwt
     * @return
     * @throws UnsupportedEncodingException
     */
    public static String JWTParse(String jwt) throws UnsupportedEncodingException {
        String[] split = jwt.split("\\.");
        byte[] decodedBytes = Base64.decode(split[1], Base64.URL_SAFE);
        return new String(decodedBytes, "UTF-8");
    }
}
