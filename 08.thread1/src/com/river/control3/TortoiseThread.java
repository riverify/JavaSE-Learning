package com.river.control3;

/**
 * 定义一个乌龟线程类
 */
public class TortoiseThread extends Thread {
    /**
     * 线程体-线程要执行的任务
     */
    @Override
    public void run() {
        while (true) {
           System.out.println("乌龟领先了，加油" + "  " + this.getName() + "  " + this.getPriority());
        }
    }
}
