package com.river.sync4;


import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class TicketRunnerable2 implements Runnable {

    private int ticketNum = 100;
    Lock lock = new ReentrantLock();

    @Override
    public void run() {
        while(true) {

            lock.lock();
            try {
                if (ticketNum <= 0) {
                    break;
                }
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + "卖出了第" + ticketNum + "张票");
                ticketNum--;
            } finally {
                lock.unlock();
            }
        }
    }

    public static void main(String[] args) {
        // 创建四个线程模拟四个窗口
        Runnable runnable = new TicketRunnerable2();
        Thread thread1 = new Thread(runnable);
        Thread thread2 = new Thread(runnable);
        Thread thread3 = new Thread(runnable);
        Thread thread4 = new Thread(runnable);
        // 开始卖票线程
        thread1.start();
        thread2.start();
        thread3.start();
        thread4.start();
    }
}
