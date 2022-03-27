package com.river.list2;

import java.util.*;

public class TestStackQueue {
    public static void main(String[] args) {
        //栈
        //public
        //class Stack<E> extends Vector<E> 已经过时
        Stack stack = new Stack();

        //双端队列 可以作为栈使用 push()入栈  pop()出栈  peek()获取栈顶元素
        Deque deque;// ArrayDeque底层是数组 LinkedList底层是链表

        //队列
        Queue queue;// ArrayDeque底层是数组 LinkedList底层是链表

        //模拟摞盘子
        Deque<String> deque1 = new LinkedList<>();
        //放入盘子1
        deque1.push("盘子1");
        //放入盘子2
        deque1.push("盘子2");
        //输出此时顶层盘子
        System.out.println(deque1.peek());
        //放入盘子3
        deque1.push("盘子3");
        //收回盘子，并依次输出它们
        while(!deque1.isEmpty()){
            String elem = deque1.pop();
            System.out.println(elem);
        }
    }
}
