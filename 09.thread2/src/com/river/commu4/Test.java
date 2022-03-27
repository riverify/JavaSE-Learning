package com.river.commu4;

public class Test {
    public static void main(String[] args) {
        Product product = new Product();
        Runnable runnable1 = new ProduceRunnable(product);
        Thread thread1 = new Thread(runnable1);

        Runnable runnable2 = new ConsumeRunnable(product);
        Thread thread2 = new Thread(runnable2);

        thread1.start();
        thread2.start();
    }
}
