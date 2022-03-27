package com.river.commu4;

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
            product.produce(i);
            i++;
        }

    }
}
