package com.river.other;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.ListIterator;

public class TestListIterator {
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();

        list.add("JavaSE");
        list.add("MySQL");
        list.add("JavaEE");

        ListIterator<String> lit = list.listIterator();

        while (lit.hasNext()) {
            String elem = lit.next();
            System.out.println(elem);
        }

        while (lit.hasPrevious()) {
            String elem = lit.previous();
            System.out.println(elem);
        }
    }
}
