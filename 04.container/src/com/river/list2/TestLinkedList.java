package com.river.list2;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

/**
 * LinkedList
 *  与ArrayList相比
 *      1.运行结果没有变
 *      2.代码没有变
 *      3.但是底层的存储结构发生改变
 *      4.功能的底层实现变了
 *          如add(2,100)
 *          ArrayList需要大量的后移元素操作
 *          LinkedList只需要修改前后节点的指针 效率高
 *          get(2)
 *          ArrayList计算地址1012+4*2
 *          LinkedList顺藤摸瓜，逐个查找 效率低
 *
 *   到底该使用哪个视情况而定
 *      按索引查找多：ArrauList
 *      删增操作多：LinkedList
 *
 *   LinkedList相比ArrayList多了几种特有的方法，如addFirst addLast removeFirst removeLast getFirt getLast ...
 *
 *   平时使用，推荐使用向上转型
 *   List<Integer> list = new ArrayList<Integer>()
 *   并避免使用LinkedList特有的几种方法
 */
public class TestLinkedList {
    public static void main(String[] args) {
        // 1.创建一个ArrayList对象，用来存储多个分数
//        ArrayList<Integer> list = new ArrayList<Integer>();
        LinkedList<Integer> list = new LinkedList<Integer>();

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
