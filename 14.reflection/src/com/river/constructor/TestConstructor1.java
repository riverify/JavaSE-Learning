package com.river.constructor;

import java.lang.reflect.InvocationTargetException;

public class TestConstructor1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 1.获取类的完整路径字符 串
        String className = "com.river.why.Dog";
        // 2.根据完整路径字符串获取类对象
        Class clazz = Class.forName(className);
//        // 3.从类对象中获取无参构造方法
//        Constructor cons = clazz.getConstructor();
//        // 4.使用反射创建对象
//        Object obj = cons.newInstance();
        Object obj = clazz.getConstructor().newInstance();

        System.out.println(obj);

    }
}
