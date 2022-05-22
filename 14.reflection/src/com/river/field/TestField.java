package com.river.field;

import com.river.why.Animal;
import com.river.why.Dog;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;

/**
 * 使用反射操作属性，而非调用方法
 */
public class TestField {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        // do not use reflection
        Dog dog = new Dog();
//        dog.type = "little";
//        String type = dog.type;

        // 使用反射操作属性
        // １.获取类的完整路径字符串
        String className = "com.river.why.Dog";
        // 2.得到类的类对象
        Class clazz = Class.forName(className);
        // 3.使用反射创建对象
        Animal obj = (Animal) clazz.newInstance();
        // 4.从class中获取属性
        Field f = clazz.getDeclaredField("type");
        // 5.使用反射操作属性
        f.setAccessible(true);
        f.set(obj, "big dog");
        Object result = f.get(obj);
        System.out.println(result);


    }
}
