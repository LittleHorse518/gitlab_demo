package org.example;

import java.lang.reflect.Method;
import java.util.List;

public class GenericMethods {
    public static <T> void genericMethod(T parameter) {
        System.out.println("Received parameter: " + parameter);
    }


    public static <T extends Comparable<T>> T max(T a, T b) {
        return a.compareTo(b) > 0 ? a : b;
    }

    public static <T> void addToList(List<T> list, T element) {
        list.add(element);
    }

    public static <T> Class<?> getRawType(T t) {
        return t.getClass();
    }

    public static <T> void reflectionTest(T t) {
        try {
            Method method = t.getClass().getMethod("toString");
            Object result = method.invoke(t);
            System.out.println("Reflection result: " + result);
        } catch (Exception e) {
            System.out.println("Reflection failed: " + e.getMessage());
        }
    }
}
