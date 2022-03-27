package com.river.oops;

/**
 * 计算器类
 *
 */
public class Calculator {
    //成员变量  静态特征
    String brand;//品牌
    double size;//尺寸
    //成员方法  动态行为
    public int add(int num1,int num2){ //局部变量
        int result;//局部变量
        result = num1 + num2;
        return result;
    }
    public int sub(int num1,int num2){
        int result;
        result = num1 - num2;
        return result;
    }
    public void show(){
        System.out.println("品牌："+brand+"\t"+"尺寸："+size);
    }

    public static void main(String[] args) {
        //创建一个计算器
        Calculator calc=new Calculator();
        //操作属性
        calc.brand="奔驰牌";
        calc.size=6.72;
        //执行功能
        int resultAdd=calc.add(12,18);
        int resultSub=calc.sub(30,12);
        System.out.println("12+18="+resultAdd);
        System.out.println("30-12="+resultSub);
    }
}
