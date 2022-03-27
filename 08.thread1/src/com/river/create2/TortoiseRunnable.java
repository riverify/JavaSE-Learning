package com.river.create2;

public class TortoiseRunnable implements Runnable {
    @Override
    public void run() {
        while (true) {
            System.out.println("乌龟领先了，牛逼" + "  " + Thread.currentThread().getName() +
                    "  " + Thread.currentThread().getPriority());
        }
    }
}
