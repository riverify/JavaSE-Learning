package com.river.recursion;

// 递归的缺点：内存占用多，速度慢
// 递归的优点：代码简单，思路自然

//关于递归的基本原理
/*
    n! = n * (n - 1)!
    (n - 1)! = (n - 1) * (n - 2)!
    ...
    ...
    2! = 2 * 1!
    1! = 1
 */
public class TestRecursion1 {
    public static void main(String[] args) {
        // 不使用递归，使用循环计算n!
        long result = 1;
        int n = 6;
        for (int i = 1; i <= n; i++) {
            result *= i;
        }
        System.out.println("Result1 = " + result);
        // 使用递归计算n!
        result = fac(n);
        System.out.println("Result2 = " + result);
    }
    public static long fac(int n){
        long result;
        if (n > 1){
            result = n * fac(n - 1); // zi
        }else{
            // 递归的结束条件
            result = 1;
        }
        return result;
    }
}
