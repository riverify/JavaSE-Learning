package com.river.create2;

public class TestThread2 {
    public static void main(String[] args) {
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                while (true) {
                    System.out.println("乌龟领先了，牛逼" + "  " + Thread.currentThread().getName() +
                            "  " + Thread.currentThread().getPriority());
                }
            }
        };

        Thread thread1 = new Thread(runnable);
        thread1.setName("乌龟1线程");
        thread1.setPriority(Thread.NORM_PRIORITY);
        thread1.start();

        // 兔子也在跑
        Thread.currentThread().setName("兔子线程1");
//        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        while (true) {
            System.out.println("兔子领先了，加油" + "  " + Thread.currentThread().getName() + "  " +
                    Thread.currentThread().getPriority());
        }

    }
}
