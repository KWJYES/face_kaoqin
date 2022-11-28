package com.response.db;

import static android.content.Context.MODE_PRIVATE;

import android.content.SharedPreferences;
import android.util.Log;

import com.utils.ApplicationConfig;

public class SharedPreferencesManager implements ISharedPreferencesRequest{

    /**
     * 使用单例模式
     */
    private SharedPreferencesManager(){}
    private static SharedPreferencesManager sharedPreferencesManager;
    public static SharedPreferencesManager getInstance(){
        if(sharedPreferencesManager==null){
            synchronized (SharedPreferencesManager.class){
                if(null==sharedPreferencesManager){
                    sharedPreferencesManager=new SharedPreferencesManager();
                }
            }
        }
        return sharedPreferencesManager;
    }

    private SharedPreferences.Editor editor;
    private SharedPreferences.Editor getEditor(){
        if(editor==null){
            synchronized (SharedPreferences.Editor.class){
                if(null==editor){
                    editor=ApplicationConfig.getContext().getSharedPreferences("data",MODE_PRIVATE).edit();
                }
            }
        }
        return editor;
    }

    private SharedPreferences pref;
    private SharedPreferences getPref(){
        if(pref==null){
            synchronized (SharedPreferences.class){
                if(null==pref){
                    pref= ApplicationConfig.getContext().getSharedPreferences("data",MODE_PRIVATE);
                }
            }
        }
        return pref;
    }

    @Override
    public void saveToken(String token) {
        getEditor().putString("token",token).apply();
        Log.d("SharedPreferencesManager","save token="+token);
    }

    @Override
    public void saveRefreshToken(String refresh_token) {
        getEditor().putString("refresh_token",refresh_token).apply();
        Log.d("SharedPreferencesManager","save refresh_token="+refresh_token);
    }

    @Override
    public String getToken() {
        return getPref().getString("token","");
    }

    @Override
    public String getRefreshToken() {
        return getPref().getString("refresh_token","");
    }
}
