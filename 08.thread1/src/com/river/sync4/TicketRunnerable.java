package com.river.sync4;


public class TicketRunnerable implements Runnable {

    private int ticketNum = 100;

    @Override
    public void run() {
        while(ticketNum > 0) {
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "卖出了第" + ticketNum + "张票");
            ticketNum--;
        }
    }

    public static void main(String[] args) {
        // 创建四个线程模拟四个窗口
        Runnable runnable = new TicketRunnerable();
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
