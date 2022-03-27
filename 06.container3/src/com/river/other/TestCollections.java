package com.river.other;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Vector;

public class TestCollections {
    public static void main(String[] args) {
        // 1.添加元素
        List<Integer> list = new ArrayList<>();
        System.out.println(list);
        Collections.addAll(list, 83, 14, 23, 15, 41, 32);
        System.out.println(list);

        // 2.排序
        Collections.sort(list);
        System.out.println(list);

        // 3.查找 （必须有序）
        int index = Collections.binarySearch(list, 41);
        System.out.println(index);

        // 4.最大值最小值
        int max = Collections.max(list);
        int min = Collections.min(list);
        System.out.println("max = " + max + "\nmin = " + min);

        // 5.填充
        //Collections.fill(list, 100);
        //System.out.println(list);

        // 6.复制
        List list2 = new ArrayList();
        Collections.addAll(list2, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0);
        Collections.copy(list2, list);
        System.out.println(list2);

        // 7.同步
        // 第一代集合类 Vector、Hashtable 线程安全 效率低 多线岑
        //Vector v;
        // 第二代集合类 Arraylist、Hashmap 线程不安全 效率高 单线程
        // 如果既希望速度快，又希望线程安全，还不使用第一代集合类，
        // 方法1；如果是多线程，对第二代集合类加锁
        list = Collections.synchronizedList(list);

    }
}
