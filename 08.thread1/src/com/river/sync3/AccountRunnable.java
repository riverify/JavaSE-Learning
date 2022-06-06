package com.river.sync3;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Lock锁 -- re-entrant-lock 可重 入 锁
 */
public class AccountRunnable implements Runnable {
    private final Account account = new Account();

    // 得到锁
    private final Lock lock = new ReentrantLock();

    @Override
    public void run() {
        //...

        // 上锁  为了防止上锁后代码出现异常，使得解锁未成功，需要手动将锁住的内容try，并用finally解锁
        lock.lock();
        try {
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
        } finally {
            // 解锁
            lock.unlock();
        }

        //...
    }
}
