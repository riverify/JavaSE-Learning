package com.river.create2;

public class TestThread {
    public static void main(String[] args) {
        // 启动乌龟线程
        Runnable runnable = new TortoiseRunnable();
        Thread thread1 = new Thread(runnable);
        thread1.setName("乌龟1线程");
        thread1.start();
        Thread thread2 = new Thread(runnable, "乌龟2线程");
        thread2.start();

        // 兔子也在跑
        Thread.currentThread().setName("兔子线程1");
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        while (true) {
            System.out.println("兔子领先了，加油" + "  " + Thread.currentThread().getName() + "  " +
                    Thread.currentThread().getPriority());
        }

    }
}
