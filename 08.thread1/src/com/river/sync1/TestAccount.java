package com.river.sync1;



public class TestAccount {
    public static void main(String[] args) {
        // 创建两个线程，模拟两个用户
        Runnable runnable = new AccountRunnable();
        Thread thread1 = new Thread(runnable, "River");
        Thread thread2 = new Thread(runnable, "River's wife");

        // 两个用户取同一账号款
        thread1.start();
        thread2.start();
    }
}
