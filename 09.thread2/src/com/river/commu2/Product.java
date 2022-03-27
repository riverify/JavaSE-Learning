package com.river.commu2;

public class Product {

    private String productName;
    private String productColor;

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
}
