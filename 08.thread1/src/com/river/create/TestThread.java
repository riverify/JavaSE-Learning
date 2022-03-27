package com.river.create;

/**
 * 创建一个线程对象，并启动线程
 */
public class TestThread {
    public static void main(String[] args) {

        // 启动乌龟线程
        Thread thread = new TortoiseThread();
        Thread thread2 = new TortoiseThread();
        thread.setName("乌龟1线程");
        thread2.setName("乌龟2线程");
        thread.start();
        thread2.start();

        // 兔子也在跑
        Thread.currentThread().setName("兔子线程1");
        while (true) {
            System.out.println("兔子领先了，加油" + "  " + Thread.currentThread().getName() + "  " +
                                Thread.currentThread().getPriority());
        }

    }
}
