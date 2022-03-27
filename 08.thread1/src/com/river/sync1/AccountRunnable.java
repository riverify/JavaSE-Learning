package com.river.sync1;

/**
 * 取款的线程
 */
public class AccountRunnable implements Runnable {
    private final Account account = new Account();

    @Override
    public void run() {
        //...

        // 容易产生安全问题的地方用
        synchronized (account) {
            if (!(account.getBalance() < 400)) {
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

        //...

    }
}
