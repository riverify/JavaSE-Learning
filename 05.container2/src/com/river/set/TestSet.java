package com.river.set;

import java.util.*;

/**
 *  使用set存储课程信息
 *
 *  HashSet 唯一 无序  哈希表（快）
 *  LinkedHashSet 唯一 有序（添加时的顺序）  哈希表（快） + 链表（有序）
 *  treeSet 唯一 有序（自然顺序）  红黑树
 *
 *  Set相比Collection，没有增加任何方法  而List却增加了和索引相关的一些方法
 */
public class TestSet {
    public static void main(String[] args) {
        //创建一个set对象
        //Set<String> set = new HashSet<String>();
        //Set<String> set = new LinkedHashSet<String>();
        Set<String> set = new TreeSet<String>();
        //添加元素
        set.add("Java");
        set.add("MySQL");
        set.add("JavaEE");
        set.add("HTML");
        set.add("SSM");
        set.add("Java");
        //遍历输出
        System.out.println(set.size());
        System.out.println(set);
        //遍历1 for-each
//        for (int i = 0; i < set.size(); i++) {
//            set.get(i); //由于无序，故无与索引有关的方法
//        }
        for (String elem:set) {
            System.out.println(elem);
        }
        //遍历2 使用迭代器
        Iterator<String> it = set.iterator();
        while(it.hasNext()){
            String elem = it.next();
            System.out.println(elem);
        }
    }
}