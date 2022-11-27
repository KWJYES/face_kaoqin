package com.tencent.ncnnyoloface;

import androidx.appcompat.app.AppCompatActivity;

import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.baidu.ai.aip.utils.BackTool;
import com.baidu.ai.aip.utils.GsonUtils;
import com.baidu.ai.aip.utils.HttpUtil;
import com.baidu.ai.aip.utils.MyHelper;
import com.baidu.ai.aip.utils.add_result_bean;
import com.google.gson.Gson;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DeleteInfoActivity extends AppCompatActivity implements View.OnClickListener {

    Button btn_confirm;
    EditText et_user;
    String S_user;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete_info);
        btn_confirm=(Button)findViewById(R.id.confirm);
        btn_confirm.setOnClickListener(this);
        et_user=(EditText)findViewById(R.id.user);
    }
    @Override
    public void onClick(View v) {
        S_user=et_user.getText().toString().trim();
        runthreaad();
    }

    void runthreaad()
    {
        new Thread(new Runnable() {
            @Override
            public void run() {
                String url ="https://aip.baidubce.com/rest/2.0/face/v3/faceset/user/delete";
                try {
                    Map<String, Object> map = new HashMap<>();
                    map.put("group_id", "group1");
                    map.put("user_id", S_user);
                    String param = GsonUtils.toJson(map);
                    // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
                    String clientId = "pBGlkzkya71PFTwnkrOW9ogI";
                    // 官网获取的 Secret Key 更新为你注册的
                    String clientSecret = "46YjTfkAuSrOaoaXc1jH4flBHhKN8GQz";
                    String accessToken = getAuth(clientId, clientSecret);



                    String result = HttpUtil.post(url, accessToken, "application/json", param);
                    System.out.println(result);

                    Gson gson=new Gson();
                    add_result_bean Result_bean=gson.fromJson(result,add_result_bean.class);

                    int Error_code=Result_bean.getError_code();
                    if(Error_code==0){

                        String message="id=\""+  S_user   +"\"";
                        SQLiteDatabase db;
                        MyHelper ggg= new MyHelper(DeleteInfoActivity.this);
                        db=ggg.getWritableDatabase();
                        ggg.Delete(db,"name_id",message);


                        BackTool.SendHttpDelete_orQueryAllface(S_user,1);


                        Looper.prepare();
                        Toast.makeText(DeleteInfoActivity.this,"删除成功" , Toast.LENGTH_LONG).show();
                        Looper.loop();
                    }else{
                        String message="id=\""+  S_user   +"\"";
                        System.out.println("删除:"+message);

                        SQLiteDatabase db;
                        MyHelper ggg= new MyHelper(DeleteInfoActivity.this);
                        db=ggg.getWritableDatabase();
                        ggg.Delete(db,"name_id",message);

                        BackTool.SendHttpDelete_orQueryAllface(S_user,1);

                        String error_message="删除失败："+Result_bean.getError_msg();
                        System.out.println("xixixixixixi"+ error_message);

                        Looper.prepare();
                        Toast.makeText(DeleteInfoActivity.this,error_message , Toast.LENGTH_LONG).show();
                        Looper.loop();
                    }

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    public static String getAuth(String ak, String sk) {
        // 获取token地址
        String authHost = "https://aip.baidubce.com/oauth/2.0/token?";
        String getAccessTokenUrl = authHost
                // 1. grant_type为固定参数
                + "grant_type=client_credentials"
                // 2. 官网获取的 API Key
                + "&client_id=" + ak
                // 3. 官网获取的 Secret Key
                + "&client_secret=" + sk;
        try {

            URL realUrl = new URL(getAccessTokenUrl);
            // 打开和URL之间的连接
            HttpURLConnection connection = (HttpURLConnection) realUrl.openConnection();
            connection.setRequestMethod("GET");
            connection.connect();
            // 获取所有响应头字段
            Map<String, List<String>> map = connection.getHeaderFields();
            // 遍历所有的响应头字段
            for (String key : map.keySet()) {
                System.err.println(key + "--->" + map.get(key));
            }
            // 定义 BufferedReader输入流来读取URL的响应
            BufferedReader in = new BufferedReader(new InputStreamReader(connection.getInputStream()));
            String result = "";
            String line;
            while ((line = in.readLine()) != null) {
                result += line;
            }

            System.err.println("result:" + result);
            JSONObject jsonObject = new JSONObject(result);
            String access_token = jsonObject.getString("access_token");
            return access_token;
        } catch (Exception e) {
            System.err.printf("获取token失败！");
            e.printStackTrace(System.err);
        }
        return null;
    }
}