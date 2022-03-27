package com.river.sync3;

public class Account {
    private int balance = 500;

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
