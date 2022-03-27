package com.river.abstractDemo;

public class TestAbstract {
    public static void main(String[] args) {
        //AbstractExample e1 = new AbstractExample(); // 'AbstractExample' is abstract; cannot be instantiated
        AbstractExtendClassExample e2 = new AbstractExtendClassExample();
        e2.func1();  // func1
    }
}
