package org.example;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectMethod {

    public String reflectMethodPrivateCall(String str) {
        StringProcessor stringProcessor = new StringProcessor();
        try {
            Method processMethod = StringProcessor.class.getDeclaredMethod("processA", String.class);
            processMethod.setAccessible(true);
            String reflectMethodCall = processMethod.invoke(stringProcessor, str).toString();
            if(reflectMethodCall.equals("testA")){
                return reflectMethodCall;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

    public String reflectMethodPublicCall(String str) {
        StringProcessor stringProcessor = new StringProcessor();
        try {
            Method processMethod = StringProcessor.class.getDeclaredMethod("processB", String.class);
            String reflectMethodCall = processMethod.invoke(stringProcessor, str).toString();
            if(reflectMethodCall.equals("testA")){
                return reflectMethodCall;
            } else {
                return null;
            }
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

}
