package com.river.geniric;


import java.lang.reflect.Array;

// ArrayList为泛型类
public class ArrayList<E> implements List<E> {

    private E elem;

    @Override
    public void add(E elem) {
        this.elem = elem;
    }

    @Override
    public E get(int index) {
        return null;
    }

    public static void main(String[] args) {
        ArrayList<Student> list1 = new ArrayList<Student>();
        ArrayList<String> list2 = new ArrayList<String>();
    }
}
