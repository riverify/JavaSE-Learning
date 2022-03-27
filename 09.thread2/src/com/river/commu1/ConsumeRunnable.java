package com.river.commu1;

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
            System.out.println("消费者消费了一份" + product.getProductColor() + product.getProductName());
        }
    }
}
