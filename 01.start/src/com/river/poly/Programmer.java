package com.river.poly;

public class Programmer {
    private String name = "proName";

    //子类继承的方法
    public void writeCode(){
        System.out.println("=======Pro coding======");
    }
    //子类重写的方法
    public void eat(){
        System.out.println("========Pro eating=======");
    }
}
