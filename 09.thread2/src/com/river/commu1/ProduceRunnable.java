package com.river.commu1;

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
            if (i % 2 == 0) {
                product.setProductName("馒头");
                product.setProductColor("白色");
            } else {
                product.setProductName("玉米饼");
                product.setProductColor("黄色");
            }
            System.out.println("生产者生产了一份" + product.getProductColor() + product.getProductName());
            i++;
        }

    }
}
