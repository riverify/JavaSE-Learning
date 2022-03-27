package com.river.sync2;

/**
 * 同步方法 效率低于 同步代码块
 */
public class AccountRunnable implements Runnable {
    private Account account = new Account();
    @Override
    public void run() {

        //...

        withDraw();

        //...
    }



    public synchronized void withDraw() {  // 非静态同步方法的锁是this
        if (account.getBalance() >= 400) {
            try {
                Thread.sleep(1);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            account.withDraw(400);
            System.out.println(Thread.currentThread().getName() + "取款成功,当前余额：" + account.getBalance());
        } else {
            System.out.println(Thread.currentThread().getName() + "取款失败，余额不足，当前余额：" + account.getBalance());
        }
    }

    public synchronized void method1() { // 锁也是this

    }

    public synchronized static void method2() { // 静态同步方法的锁是 类名.class
//        Class clazz = AccountRunnable.class;
    }
}
