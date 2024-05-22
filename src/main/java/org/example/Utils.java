package org.example;


import org.example.bean.DBMapper;
import org.example.bean.UserObj;

public class Utils {
    public static String testUtil(String input){
        if("input".equals(input)){
            return input + "Test";
        }
        return input;
    }

    public String userGetName(UserObj obj){
        return obj.getName();
    }
}
