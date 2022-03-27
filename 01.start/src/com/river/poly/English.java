package com.river.poly;

public class English extends Programmer {
    //继承的方法writeCode

    //重写的方法eat()

    @Override
    public void eat() {
        System.out.println("English eat by knives");
    }

    //子类特有的方法
    public void raceHorse(){
        System.out.println("========English like racing horses========");
    }
}
