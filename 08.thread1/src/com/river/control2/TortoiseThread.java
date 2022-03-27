package com.river.control2;

/**
 * 定义一个乌龟线程类
 */
public class TortoiseThread extends Thread {
    /**
     * 线程体-线程要执行的任务
     */
    @Override
    public void run() {
        int i = 0;
//        this.setName("Tortoise Thread");
//        this.setPriority(Thread.MAX_PRIORITY);
        while (i <= 100) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("乌龟领先了，加油" + "  " + this.getName() + "  " + this.getPriority() + "  " + i);
            i++;
        }
    }
}
