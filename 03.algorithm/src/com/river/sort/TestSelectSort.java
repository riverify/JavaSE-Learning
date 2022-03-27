package com.river.sort;

import java.util.Arrays;

public class TestSelectSort {
    public static void main(String[] args) {
        // 1.给定一个初始数组
        int[] arr = {12,23,42,1,21,52,3,54,34,6,15,9};
        // 2.排序前输出
        System.out.println("排序前："+ Arrays.toString(arr));
        // 3.排序
        selectSort(arr);
        // 3.排序后输出
        System.out.println("排序后："+ Arrays.toString(arr));
    }

    /**
     * 选择排序
     * @param arr 需要被排序的数组
     */
    public static void selectSort(int[] arr){
        // 大循环
        for (int i = 0; i < arr.length; i++) {
            // 假设第一个无序数列的第一个数是最小的
            int minIndex = i;
            // 小循环
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]){
                    minIndex = j;
                }
            }
            // 如果minIndex变化了，则交换
            if (minIndex != i){
                int temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }

    public static void selectSort(Comparable[] arr){
        // 大循环
        for (int i = 0; i < arr.length; i++) {
            // 假设第一个无序数列的第一个数是最小的
            int minIndex = i;
            // 小循环
            for (int j = i+1; j < arr.length; j++) {
                if (arr[j].compareTo(arr[minIndex]) < 0){
                    minIndex = j;
                }
            }
            // 如果minIndex变化了，则交换
            if (minIndex != i){
                Comparable temp = arr[minIndex];
                arr[minIndex] = arr[i];
                arr[i] = temp;
            }
        }
    }
}
