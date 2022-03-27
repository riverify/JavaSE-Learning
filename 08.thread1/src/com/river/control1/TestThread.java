package com.river.control1;

/**
 *  join()
 */
public class TestThread {
    public static void main(String[] args) {

        // 兔子也在跑
        Thread.currentThread().setName("兔子线程1");
        int i = 0;
        while (i <= 100) {
            if (i == 50) {
                // 启动乌龟线程
                Thread thread = new TortoiseThread();
                thread.setName("乌龟线程1");
                thread.start();
                try {
                    thread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("兔子领先了，加油" + "  " + Thread.currentThread().getName() + "  " +
                                Thread.currentThread().getPriority() + "  " + i);
            i++;
        }

    }
}
