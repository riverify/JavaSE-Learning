package com.river.test;

public class Animal extends Object {
    //成员变量
    private int age;
    //无参构造方法
    public Animal(){
    }
    //有参构造方法
    public Animal(int age) {
        this.age = age;
    }
    //公共get set
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    /**
     * 重写Object中的toString方法，显示出Animal类中成员变量的值
     * @return 返回带有成员变量信息的字符串
     */
    @Override
    public String toString() {
        return "Animal{" +
                "age=" + age +
                '}';
    }

    /**
     * 重写 Object中的equals，判断两个对象是否完全相同
     * @param obj 去比较的对象
     * @return 如果相同或者比较的对象为null，返回true，否则返回false
     */
    @Override
    public boolean equals(Object obj) {
        //如果obj为null，返回false
        if (obj == null){
            return false;
        }
        //如果指向同一个对象，返回true
        if (this==obj){
            return true;
        }
        //判断成员变量的内容是否完全相同
        Animal other=(Animal) obj;//向下转型
        return this.age == other.age;
    }
}
