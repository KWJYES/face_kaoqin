package com.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class InputChecker {
    /**
     * 检查学生ID输入格式
     * @param studentID
     * @return
     */
    public static boolean checkStudentID(String studentID){
        for (int i = 0; i < studentID.length(); i++) {
            char ch = studentID.charAt(i);
            if ((ch >= '0' && ch <= '9') || (ch >= 'a' && ch <= 'z') || (ch >= 'A' && ch <= 'Z')) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }

    /**
     * 检查是否是邮箱格式
     * @param emailStr
     * @return
     */
    public static boolean checkEmail(String emailStr){
        String RULE_EMAIL = "^\\w+((-\\w+)|(\\.\\w+))*\\@[A-Za-z0-9]+((\\.|-)[A-Za-z0-9]+)*\\.[A-Za-z0-9]+$";
        Pattern p = Pattern.compile(RULE_EMAIL);//正则表达式的模式 编译正则表达式
        Matcher m = p.matcher(emailStr);//正则表达式的匹配器
        return m.matches();//进行正则匹配
    }
}
