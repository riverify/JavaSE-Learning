package com.river.other;

import java.util.ArrayList;
import java.util.Iterator;

public class TestIterator {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add("JavaSE");
        list.add("MySQL");
        list.add("JavaEE");

        Iterator<String> it = list.iterator();
        while (it.hasNext()) {
            String elem= it.next();
            System.out.println(elem);
        }
    }
}
