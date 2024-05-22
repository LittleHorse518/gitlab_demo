package org.example;

import org.example.bean.DBMapper;
import org.example.bean.UserObj;

public class InterfaceMethod {
    public String testInterfaceMock(DBMapper dbMapper, String input){
        UserObj obj= dbMapper.createUser(input);
        String id = obj.getId();
        return id;
    }
}
