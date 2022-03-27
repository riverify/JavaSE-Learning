package com.river.sync4;


public class TicketRunnerable1 implements Runnable {

    private int ticketNum = 300;

    @Override
    public void run() {
        while(true) {
            sellOne();
            if (ticketNum <= 0)
                break;
        }
    }

    public synchronized void sellOne() {
        if (ticketNum <= 0) {
            return;
        }
        try {
            Thread.sleep(10);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "卖出了第" + ticketNum + "张票");
        ticketNum--;
    }

    public static void main(String[] args) {
        // 创建四个线程模拟四个窗口
        Runnable runnable = new TicketRunnerable1();
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
