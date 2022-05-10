package com.river.why;

import java.io.Serializable;

public final class Dog extends Animal implements Serializable,Cloneable {
    private String type;//品种

    public Dog() {
        System.out.println("===Dog()=======");
    }

    Dog(String nickName, int age, String type) {
        super(nickName, age);
        this.type = type;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public void eat() {
        System.out.println("====Dog eat()=======");
    }

    private void guard(){

    }
}
