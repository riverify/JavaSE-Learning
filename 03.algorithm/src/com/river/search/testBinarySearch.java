package com.river.search;

//非递归的折半查找
public class testBinarySearch {
    public static void main(String[] args) {
        // 定义一个有序数组
        int[] array = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        // 进行折半查找返回索引
        int key = 5;
        int index = binarySearch(array,key);
        // 输出索引
        System.out.println(index);
    }

    private static int binarySearch(int[] array, int key) {
        int low = 0;
        int high = array.length-1;
        while (low <= high) {
            // 计算mid的值
            int mid = (low + high) / 2;
            // 根据mid的值判断是否找到
            if (array[mid] == key){
                return mid;
            }else if (array[mid] > key){
                high = mid -1;
            }else if (array[mid] < key){
                low = mid + 1;
            }
        }
        // 不存在就返回-1
        return -1;
    }
}
