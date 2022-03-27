package com.river.encap;

public class BookTest {
    public static void main(String[] args) {
        Books book1=new Books();
        book1.setBookName("《Java从入门到入土》");
        book1.setAuthor("RiverLuo");
        book1.setPublisher("WDNMD PRESS");
        book1.setPrice(998.8);
        book1.show();

        Books book2=new Books("《学习，学个屁！》","不学无术","不学无术出版社",9.8);
        book2.show();
    }
}
