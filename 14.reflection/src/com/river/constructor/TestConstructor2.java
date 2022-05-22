package com.river.constructor;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;

public class TestConstructor2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        // 有参数的构造方法
        // 不使用反射
//        Dog dog1 = new Dog("memo", 5, "little dog");
//        System.out.println(dog1);

        // 使用反射
        Class clazz = Class.forName("com.river.why.Dog");
        Constructor cons = clazz.getDeclaredConstructor(String.class, int.class, String.class); // 能获取私有的方法
        cons.setAccessible(true); // 设置访问权限
        Object obj = cons.newInstance("funny", 3, "big dog");
        System.out.println(obj);
    }

}
