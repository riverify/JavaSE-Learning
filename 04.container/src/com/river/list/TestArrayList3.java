package com.river.list;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * ArrayList的其他方法
 */
public class TestArrayList3 {
    public static void main(String[] args) {
        // 1.创建一个ArrayList对象，用来存储多个分数
        ArrayList<Integer> list = new ArrayList<Integer>();

        // 2.向ArrayList对象中添加元素
        list.add(67); // 集合的元素必须是对象类型，如果要放入基本数据类型，需要使用包装类，自动装箱(JDK5之后)
        list.add(89);
        list.add(78);
        list.add(89);
        list.add(96); // 向末尾添加
        list.add(2,100);

        ArrayList<Integer> list2 = new ArrayList<Integer>();
        list2.add(96);
        list2.add(89);
        list2.add(43);
        // list.removeAll(list2); // 和addAll类似，把list中list2共同拥有的的删除
        // list.retainAll(list2); // 取交集

        // 删除
//        list.clear(); // 完全删除
//        list.remove(new Integer(96)); // 按内容删除
//        list.remove(2); // 按索引删除

        // 修改
        // list.set(1,98);

        // 3.获取ArrayList中的分数
        System.out.println(list);
        System.out.println(list.size());
        System.out.println(list.get(2));
        System.out.println(list.contains(98));
        System.out.println(list.isEmpty());

    }
}
