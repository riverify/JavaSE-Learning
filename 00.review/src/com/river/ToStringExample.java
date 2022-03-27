package com.river;

public class ToStringExample {

    private int number;

    public ToStringExample(int number){
        this.number = number;
    }

    public static void main(String[] args) {
        ToStringExample toStringExample = new ToStringExample(111);
        System.out.println(toStringExample.toString());
    }
}
