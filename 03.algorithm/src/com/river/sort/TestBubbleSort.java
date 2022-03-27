package com.river.sort;

import java.util.Arrays;

// 冒泡排序算法的回顾
public class TestBubbleSort {
    public static void main(String[] args) {
        // 1.给定一个数列
        int[] arr = {12,23,18,6,3,98,67,443,234,531,123,32,34,53};
        // 2.排序前输出
        System.out.println("排序前："+ Arrays.toString(arr));
        // 3.排序
        // 大循环 n个数  至多n-1次循环
        for (int i = 0; i < arr.length-1; i++) {
            // 先假设数列是有序的
            boolean flag = true;
            // 小循环 每次循环从第一个数开始，依次比较相邻的两个
            for (int j = 0; j < arr.length-1-i; j++) {
                // 如果前一个大于后一个数
                if (arr[j] > arr[j+1]){
                    // 交换
                    int temp = arr[j];
                    arr[j] = arr[j+1];
                    arr[j+1] = temp;
                    // 如果发生了交换，则证明为无序的
                    flag = false;
                }
            }
            if (flag){
                break;
            }
        }
        // 4.排序后输出
        System.out.println("排序后："+ Arrays.toString(arr));
    }
}
