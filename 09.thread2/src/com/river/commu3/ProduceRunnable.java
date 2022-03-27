package com.river.commu3;

public class ProduceRunnable implements Runnable {

    private Product product;

    public ProduceRunnable() {
    }

    public ProduceRunnable(Product product) {
        this.product = product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
            synchronized (product) {
                // 1.如果有商品，就等待
                if (product.flag) {
                    try {
                        product.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                // 2.生产商品并输出
                if (i % 2 == 0) {
                    product.setProductName("馒头");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setProductColor("白色");
                } else {
                    product.setProductName("玉米饼");
                    try {
                        Thread.sleep(10);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.setProductColor("黄色");
                }
                System.out.println("生产者生产了一份" + product.getProductColor() + product.getProductName());
                i++;
                // 3.改变商品有无的状态
                product.flag = true;

                // 4.通知消费
                product.notify(); // 随机的唤醒一个等待的线程
            }
        }

    }
}
