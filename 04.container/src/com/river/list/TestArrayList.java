package com.river.list;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 使用ArrayList存储多个分数的信息
 */
public class TestArrayList {
    public static void main(String[] args) {
        // 1.创建一个ArrayList对象，用来存储多个分数
        ArrayList list = new ArrayList();

        // 2.向ArrayList对象中添加元素
        list.add(67); // 集合的元素必须是对象类型，如果要放入基本数据类型，需要使用包装类，自动装箱(JDK5之后)
        list.add(89);
        list.add(78);
        list.add(89);
        list.add(96); // 向末尾添加
        list.add(2,100);

        ArrayList list2 = new ArrayList();
        list2.add(54);
        list2.add(45);
        list2.add(54);

        list.addAll(list2);

        // 3.获取ArrayList中的分数
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(2));

        // 遍历ArrayList:使用for循环
        System.out.println("==========使用for循环==========");
        for (int i = 0; i < list.size(); i++) {
            int elem = (int) list.get(i);
            System.out.println(elem);
        }

        // 遍历ArrayList:使用for-each循环
        System.out.println("===========使用foreach循环===========");
        for (Object elem : list
             ) {
            System.out.println(elem);
        }

        // 遍历ArrayList:使用迭代器Iterator
        System.out.println("==========使用迭代器Iterator==========");
        Iterator it = list.iterator();
        while (it.hasNext()){
            int elem = (int) it.next();
            System.out.println(elem);
        }

    }
}
