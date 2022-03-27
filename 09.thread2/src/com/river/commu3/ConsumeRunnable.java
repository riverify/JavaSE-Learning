package com.river.commu3;

public class ConsumeRunnable implements Runnable {

    private Product product;

    public ConsumeRunnable() {
    }

    public ConsumeRunnable(Product product) {
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (product) {
                // 1.如果没有商品，就等待
                if (!product.flag) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 2.消费
                System.out.println("消费者消费了一份" + product.getProductColor() + product.getProductName());

                // 3.改变商品有无的状体
                product.flag = false;
                // 4.通知生产
                product.notifyAll(); // 唤醒所有等待的线程
            }
        }
    }
}
