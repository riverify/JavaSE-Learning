package com.river.why;

import java.lang.reflect.InvocationTargetException;

public class TestReflection {
    public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        String className = "com.river.why.Dog";
        Class clazz = Class.forName(className);
        clazz.getConstructor().newInstance();

    }
}
