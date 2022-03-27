package com.river.geniric;

import java.util.ArrayList;
import java.util.List;

public class TestGeneric {
    public static void main(String[] args) {
        ArrayList<Integer> list = new ArrayList();
        list.add(123);
//        list.add(true);
//        list.add("abc");

        for (int i = 0; i < list.size(); i++) {
            //int elem = (Integer) list.get(i);
            int elem = list.get(i);
            System.out.println(elem);
        }
    }
}
