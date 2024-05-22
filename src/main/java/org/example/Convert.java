package org.example;


import lombok.NoArgsConstructor;
import org.example.bean.UserObj;

@NoArgsConstructor
public class Convert {

    public String convertStr(String str){
        return str + " has been converted";
    }

    public Boolean checkPwd(String pwd){
        if(pwd.length() < 3){
            return true;
        } else {
            return false;
        }
    }

    public UserObj getUserObj(){
        return UserObj.builder().build();
    }
}
