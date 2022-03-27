package com.river.poly;

public class Cartoon {
    //使用父类做方法的形参，实参可以是任意子类对象的引用
    public static void showEat(Programmer pro){
        pro.eat();
    }
/*
//    public static void showEat(Chinese pro){
//        pro.eat();
//    }
//    public static void showEat(English pro){
//        pro.eat();
//    }
//    public static void showEat(Italian pro){
//        pro.eat();
//    }
*/
    public static void main(String[] args) {
        //程序员吃饭
        Programmer pro=new Programmer();
        showEat(pro);
        //中国程序员吃饭
        Chinese cn=new Chinese();
        showEat(cn);
        Programmer pro2=new Programmer();
        
        //英国程序员吃饭
        English en=new English();
        showEat(en);
        //意大利程序员吃饭
        Italian it=new Italian();
        showEat(it);
    }

}
