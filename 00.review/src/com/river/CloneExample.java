package com.river;

public class CloneExample implements Cloneable{

    private int a;
    private int b;

    @Override
    protected Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    public static void main(String[] args) {
        CloneExample cloneExample = new CloneExample();
        try {
            CloneExample cloneExample1 = (CloneExample) cloneExample.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
    }
}
