package com.river.geniric;

/*
    泛型只作用于编译阶段，不会进入运行阶段
 */
public class Collections {

    public <T> void addAll(T t){
    }

    public static <T> void method1(T t){

    }

    public static <E> void method2(List<E> list){

    }

    public static <E> void method3(List<Teacher> list){

    }

    public static <E> void method4(List<? super Teacher> list){// 下限

    }

    public static <E> void method5(List<? extends Teacher> list){// 上限

    }

    public static <E> void method6(List<?> list){

    }

    public static void main(String[] args) {
        method2(new ArrayList<String>());
        method2(new ArrayList<Person>());
        method2(new ArrayList<Teacher>());
        method2(new ArrayList<MiddleTeacher>());

        //method3(new ArrayList<String>());
        //method3(new ArrayList<Person>());
        method3(new ArrayList<Teacher>());
        //method3(new ArrayList<MiddleTeacher>());

        method4(new ArrayList<Object>());
        method4(new ArrayList<Person>());
        method4(new ArrayList<Teacher>());
        //method4(new ArrayList<MiddleTeacher>());

        //method5(new ArrayList<Person>());
        method5(new ArrayList<Teacher>());
        method5(new ArrayList<MiddleTeacher>());

        method6(new ArrayList<String>());
        method6(new ArrayList<Person>());
        method6(new ArrayList<Teacher>());
        method6(new ArrayList<MiddleTeacher>());

    }
}

class Person{

}

class Teacher extends Person{

}

class MiddleTeacher extends Teacher{

}
