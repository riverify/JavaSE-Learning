package com.river.poly;

public class TestPoly {
    public static void main(String[] args) {
        Programmer pro=new Chinese();
        Chinese cn=(Chinese) pro;
        cn.playBox();
        Chinese cnn=new Chinese();
        cnn.playBox();
    }

}
