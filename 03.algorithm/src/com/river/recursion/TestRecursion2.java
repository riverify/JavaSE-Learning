package com.river.recursion;

// 利用递归计算斐波那契数列
public class TestRecursion2 {
    public static void main(String[] args) {
        // 1.使用循环计算斐波那契数列第n项
        int num1 = 1;
        int num2 = 1;
        int numn = 0;
        int n = 40;
        for (int i = 3; i <= n; i++) {
            // 计算第i项的值
            numn = num1 + num2;
            // 改变num1 num2的值
            num1 = num2;
            num2 = numn;
        }
        System.out.println(numn);
        // 2.使用递归计算斐波那契数列第n项
        System.out.println(fibo(n));
    }
    public static int fibo(int n){
        if (n == 1 || n == 2){// 递归的结束条件
            return 1;
        }else {
            return fibo(n-1) +fibo(n - 2);
        }
    }
}
