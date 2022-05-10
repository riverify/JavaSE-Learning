package com.river.clazz;

import com.river.why.Dog;

import java.lang.reflect.Modifier;

public class TestClass2 {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException {
        // 1.获取对类
        // 方法１
//        Class clazz = Class.forName("com.river.why.Dog");
        // 方法２
//        Class clazz = Dog.class;
        // 方法３
        Dog dog = new Dog();
        Class clazz = dog.getClass();

        System.out.println(clazz);
        System.out.println(clazz.getName());
        System.out.println(clazz.getSimpleName());
        System.out.println(clazz.getSuperclass());
        System.out.println(clazz.getModifiers());
        System.out.println(Modifier.toString(clazz.getModifiers()));

    }
}
