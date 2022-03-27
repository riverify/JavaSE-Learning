package com.river;

public class OuterClass {  // 外部类
    // 非静态内部类
    class InnerClass{
    }
    // 静态内部类
    static class StaticInnerClass{
    }

    public static void main(String[] args) {
        // InnerClass innerClass = new InnerClass();   // 'OuterClass.this' cannot be referenced from a static context
        OuterClass outerClass = new OuterClass();
        InnerClass innerClass = outerClass.new InnerClass(); // 非静态内部类依赖于外部类的实例
        StaticInnerClass staticInnerClass = new StaticInnerClass();
    }
}
