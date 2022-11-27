package com.baidu.ai.aip.utils;

import android.util.Log;

import com.entity.EventBusMessage;
import com.google.gson.Gson;
import com.utils.ApplicationConfig;

import org.greenrobot.eventbus.EventBus;

import java.util.*;

/**
 * 人脸搜索
 */
public class FaceSearch {

    /**
     * 重要提示代码中所需工具类
     * FileUtil,Base64Util,HttpUtil,GsonUtils请从
     * https://ai.baidu.com/file/658A35ABAB2D404FBF903F64D47C1F72
     * https://ai.baidu.com/file/C8D81F3301E24D2892968F09AE1AD6E2
     * https://ai.baidu.com/file/544D677F5D4E4F17B4122FBD60DB82B3
     * https://ai.baidu.com/file/470B3ACCA3FE43788B5A963BF0B625F3
     * 下载
     */
    public static String faceSearch(String base64,ArrayList<String> list, MyHelper ggg){
        // 请求url
        String url = "https://aip.baidubce.com/rest/2.0/face/v3/search";
        String token = AuthService.getAuth();
        if(base64 != null){
            try {
                Map<String, Object> map = new HashMap<>();
                map.put("image", base64);
                map.put("liveness_control", "NONE");
                map.put("group_id_list", "group1");
                //map.put("max_face_num", 10);
                map.put("image_type", "BASE64");
                map.put("quality_control", "NONE");

                String param = GsonUtils.toJson(map);

                // 注意这里仅为了简化编码每一次请求都去获取access_token，线上环境access_token有过期时间， 客户端可自行缓存，过期后重新获取。
                //String accessToken = "[调用鉴权接口获取的token]";

                String result = HttpUtil.post(url, token, "application/json", param);

                // 解析结果
                Gson gson = new Gson();                      //新建GSON
                Search_result  Result_bean=gson.fromJson(result,Search_result.class);

                int Error_code=Result_bean.getError_code();
                while (Error_code != 0){
                    result = HttpUtil.post(url, token, "application/json", param);
                    Result_bean=gson.fromJson(result,Search_result.class);
                    Error_code=Result_bean.getError_code();
                    if(Error_code == 0)
                    {
                        break;
                    }
                    Thread.sleep(300);
                }
                if(Error_code == 0){
                    double score = Result_bean.getResult().getUser_list().get(0).getScore();   //一层层进入，获取到score
                    String user = Result_bean.getResult().getUser_list().get(0).getUser_id();   //获取用户名
                    Log.i("2236","分数为："+ score + " 识别为：" + user);
                    if(score >= 75.0){
                        if(!list.isEmpty() & list.contains(user)) {
                            return "no";
                        }
                        else {
                            list.add(user);
                            /**向后端发数据**/
                            EventBusMessage eventBusMessage =new EventBusMessage();
                            eventBusMessage.msg= ApplicationConfig.BAIDU_AI_USER_ID;
                            eventBusMessage.context=user;
                            EventBus.getDefault().post(eventBusMessage);

                            return "yes";
                        }
                    }
                    else {
                        Log.i("2236","1");
                        return "no";
                    }
                }
                else{
                    Log.i("2236","2");
                    return "no";
                }
//                return result;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        return "No";
    }
}
