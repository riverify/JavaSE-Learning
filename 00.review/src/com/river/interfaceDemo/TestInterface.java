package com.river.interfaceDemo;

public class TestInterface {
    public static void main(String[] args) {
        //InterfaceExample e1 = new InterfaceExample(); // 'InterfaceExample' is abstract; cannot be instantiated
        InterfaceImplementExample e2 = new InterfaceImplementExample();
        e2.func1();
        System.out.println(InterfaceExample.x); // x is abstract
    }
}
