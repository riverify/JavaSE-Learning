package com.river.sync2;

public class Account {
    private int balance = 600;

    /**
     *  取款
     * @param money
     */
    public void withDraw(int money) {
        this.balance -= money;
    }

    /**
     *  查看余额
     * @return 余额
     */
    public int getBalance() {
        return balance;
    }
}
