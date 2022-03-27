package com.river.doge;

public class PassByValueExample {
    public static void main(String[] args) {
        Dog dog = new Dog("A");
        System.out.println(dog.getObjectAddress()); // Dog@1b6d3586
        func(dog);
        System.out.println(dog.getObjectAddress());
        System.out.println(dog.getName());  // A
        System.out.println(dog.getObjectAddress());
    }

    private static void func(Dog dog){
        System.out.println(dog.getObjectAddress()); // Dog@1b6d3586
        dog = new Dog("B"); // *notice the difference from the previous code
        System.out.println(dog.getObjectAddress()); // Dog@4554617c
        System.out.println(dog.getName()); // B
    }
}
