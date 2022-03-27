package com.river.control5;

import com.river.control3.TortoiseThread;

/**
 * interrupt()
 */
public class TestThread {
    public static void main(String[] args) {
        Thread thread = new TortoiseThread();
        thread.setName("乌龟线程1");
        thread.setPriority(Thread.MIN_PRIORITY);

//        thread.setDaemon(true); // 守护线程 should before start
        thread.start();

        // 兔子也在跑
        Thread.currentThread().setName("兔子线程1");
        int i = 0;
        while (i <= 200) {
            System.out.println("兔子领先了，加油" + "  " + Thread.currentThread().getName() + "  " +
                                Thread.currentThread().getPriority() + "  " + i);
            i++;
        }

//        thread.stop();
        thread.interrupt();  // 非结束线程，还需要线程本身检查状态的变化
    }
}
