package com.river.poly;

public class Italian extends Programmer {
    //继承的方法writeCode

    //重写的方法eat()

    @Override
    public void eat() {
        System.out.println("Italian eat pizza by hands");
    }

    //子类特有的方法
    public void palyFootball(){
        System.out.println("========Italian like to play football everyday========");
    }
}
