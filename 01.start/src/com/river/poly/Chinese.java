package com.river.poly;

public class Chinese extends Programmer{

    //继承的方法writeCode

    //重写的方法eat()

    @Override
    public void eat() {
        System.out.println("Chinese eat by chopsticks");
    }

    //子类特有的方法
    public void playBox(){
        System.out.println("========Chinese play shadow box every morning========");
    }
}
