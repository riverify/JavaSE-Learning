package com.river.commu5;

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
            product.consume();
        }
    }
}
