package org.example;

import org.example.bean.TestEnum;
import org.example.bean.UserObj;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class GeneratorUnitMethod {

    /**
     * Checks if the given string is equal to "input".
     *
     * @param str the string to be checked
     * @return true if the string is equal to "input", false otherwise
     */
    public Boolean isInput(String str){
        if (str.equals("input")) {
            return true;
        }
        else {
            return false;
        }
    }

    public void testSleep() throws InterruptedException {
        Thread.sleep(3000);
    }

    private Boolean isInputPrivate(String str){
        if (str.equals("input")) {
            return true;
        }
        else {
            return false;
        }
    }

    //本类private方法调用
    public String translate2(Map<TestEnum,UserObj> input) {
        Convert convert = new Convert();
        UserObj user = convert.getUserObj();
        Boolean inputPrivate = isInputPrivate(input.get(TestEnum.ENUM1).getName());
        if(inputPrivate){
            return "correct";
        } else {
            return "no!!!!";
        }
    }
    //本类public方法调用
    public String translate1(String input) {
        if(isInput(input)){
            return "correct";
        } else {
            return "no!!!!";
        }
    }
    //调用非本类方法
    public String callingNonNativeMethods(String str){
        Convert convert = new Convert();
        return convert.convertStr(str);
    }



    //复杂方法调用
    public String mixMethodCalling(String str){
        Convert convert = new Convert();
        return translate(convert.convertStr(str));
    }

    public String staticMethodCalling(String str){
        String output = Utils.testUtil(str);
        return output;
    }

    // 方法入参是一个自定义对象
    public String translate(String input)
    {
        input = Utils.testUtil(input);
        if (input == null) return input; // garbage in, garbage out
        int length = input.length();
        StringBuilder result = new StringBuilder(length * 2);
        int resultLength = 0;
        boolean wasPrevTranslated = false;
        for (int i = 0; i < length; i++)
        {
            char c = input.charAt(i);
            if (i > 0 || c != '_') // skip first starting underscore
            {
                if (Character.isUpperCase(c))
                {
                    if (!wasPrevTranslated && resultLength > 0 && result.charAt(resultLength - 1) != '_')
                    {
                        result.append('_');
                        resultLength++;
                    }
                    c = Character.toLowerCase(c);
                    wasPrevTranslated = true;
                }
                else
                {
                    wasPrevTranslated = false;
                }
                result.append(c);
                resultLength++;
            }
        }
        return resultLength > 0 ? result.toString() : input;
    }

    public String sayHello(String hello){
        return hello.toString();
    }

    public static boolean isEnumValueValid(TestEnum enumValue) {
        return enumValue != null && enumValue != TestEnum.ENUM1;
    }

    // 被测方法，内含静态方法-枚举类调用

    public boolean checkEnumValue(TestEnum enumValue) {
        return isEnumValueValid(enumValue);
    }
}
