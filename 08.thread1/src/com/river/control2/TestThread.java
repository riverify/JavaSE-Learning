package com.river.control2;

/**
 * sleep()
 */
public class TestThread {
    public static void main(String[] args) {
        Thread thread = new TortoiseThread();
        thread.setName("乌龟线程1");
        thread.start();

        // 兔子也在跑
        Thread.currentThread().setName("兔子线程1");
        int i = 0;
        while (i <= 100) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("兔子领先了，加油" + "  " + Thread.currentThread().getName() + "  " +
                                Thread.currentThread().getPriority() + "  " + i);
            i++;
        }

    }
}
