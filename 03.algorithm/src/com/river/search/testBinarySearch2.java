package com.river.search;

import java.time.chrono.MinguoDate;

//递归的折半查找
public class testBinarySearch2 {
    public static void main(String[] args) {
        // 定义一个有序数组
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 进行折半查找返回索引
        int key = 7;
        int index = binarySearch(array, key);
        // 输出索引
        System.out.println(index);
    }

    private static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length - 1;
        int index = binarySearch(array, key, low, high);
        return index;
    }


    private static int binarySearch(int[] array, int key, int low, int high) {
        // 递归结束条件
        if (low > high){
            return -1;
        }
        // 计算中间索引
        int mid = (low + high) / 2;
        if (array[mid] == key){
            return mid;
        }else if (array[mid] > key){
            return binarySearch(array, key, low, mid-1);
        }else {
            return binarySearch(array, key, mid+1, high);
        }
    }
}
