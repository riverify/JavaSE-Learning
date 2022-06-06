package com.river.clazz;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;

public class TestClass1 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 1.获取对类
        Class clazz = Class.forName("com.river.why.Dog");
        System.out.println(clazz);
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getModifiers());
        System.out.println(Modifier.toString(clazz.getModifiers()));

        // 成员变量
        Field f = clazz.getField("nickName");
        System.out.println(f.getModifiers());
        Field[] fields = clazz.getDeclaredFields();
        for (Field field :
                fields
        ) {
            System.out.println(f);
        }

        // 成员方法
        System.out.println("================================");
        Method[] methods = clazz.getDeclaredMethods();
        for (Method m :
                methods) {
            System.out.println(m.getName() + " " + m.getModifiers() + " " + m.getReturnType() + " "
                    + Arrays.toString(m.getParameterAnnotations()));
        }

        System.out.println("=========");
        Method method = clazz.getMethod("shout", String.class, int.class);
        System.out.println(method);

        // 构造方法
        System.out.println("====================");

//        Constructor[] constructors = clazz.getConstructors();
        Constructor[] constructors = clazz.getDeclaredConstructors();
        for (Constructor cons :
                constructors) {
            System.out.println(cons);
        }

        System.out.println("=========");
        Constructor cons = clazz.getDeclaredConstructor(String.class, int.class, String.class);
        System.out.println(cons);


    }
}
