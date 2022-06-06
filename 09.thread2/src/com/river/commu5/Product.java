package com.river.commu5;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Product {

    private String productName;
    private String productColor;
    boolean flag = false;

    private final Lock lock = new ReentrantLock();
    private final Condition produceCondition = lock.newCondition();
    private final Condition consumeCondition = lock.newCondition();

    public Product() {
    }

    public Product(String productName, String productColor) {
        this.productName = productName;
        this.productColor = productColor;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductColor() {
        return productColor;
    }

    public void setProductColor(String productColor) {
        this.productColor = productColor;
    }

    /**
     * 生产 消费
     */
    public void produce(int i) {
        lock.lock();
        try {
            // 1.如果有商品，就等待
            if (flag) {
                try {
                    produceCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 2.生产商品并输出
            if (i % 2 == 0) {
                setProductName("馒头");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProductColor("白色");
            } else {
                setProductName("玉米饼");
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                setProductColor("黄色");
            }
            System.out.println("生产者生产了一份" + productColor+ productName);

            // 3.改变商品有无的状态
            flag = true;

            // 4.通知消费
            consumeCondition.signalAll(); // 随机的唤醒一个等待的线程

        } finally {
            lock.unlock();
        }
    }

    public void consume() {
        lock.lock();
        try {
            // 1.如果没有商品，就等待
            if (!flag) {
                try {
                    consumeCondition.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            // 2.消费
            System.out.println("消费者消费了一份" + productColor + productName);

            // 3.改变商品有无的状体
            flag = false;
            // 4.通知生产
            produceCondition.signalAll(); // 唤醒所有等待的线程

        } finally {
            lock.unlock();
        }
    }
}
