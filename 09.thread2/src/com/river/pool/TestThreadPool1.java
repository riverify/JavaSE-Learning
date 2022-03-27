package com.river.pool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 使用线程池执行大量的Runnable命令
 */
public class TestThreadPool1 {
    public static void main(String[] args) {
        // create a thread pool
        // only one exit
        ExecutorService pool1 = Executors.newSingleThreadExecutor();
        // 10 fixed pools
        ExecutorService pool2 = Executors.newFixedThreadPool(10);
        // number of pools dynamically changes
        ExecutorService pool3 = Executors.newCachedThreadPool();
        // by schedule
        ExecutorService pool4 = Executors.newScheduledThreadPool(10);

        // use thread pool
        for (int i = 0; i < 200; i++) {
            Runnable command = new MyRunnabale(i);
            pool3.execute(command);
        }

        // close
        pool3.shutdown();
    }
}

class MyRunnabale implements Runnable {
    int i;
    public MyRunnabale(int i) {
        this.i = i;
    }
    @Override
    public void run() {
        System.out.println("start" + i);
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("finish" + i);
    }
}
