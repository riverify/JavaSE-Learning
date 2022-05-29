package com.river.dao.impl;

import java.util.Arrays;
import java.util.Scanner;

public class 找钱问题 {
    public static void main(String[] args) {
        // input
        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();
        int sum = sc.nextInt();
        int[] values = new int[num];
        for (int i = 0; i < values.length; i++) {
            values[i] = sc.nextInt();
        }
        sc.close();

        Arrays.sort(values);
        int[] array = new int[num];
        for (int i = 0; i < num; i++) {
            array[i] = func1(Arrays.copyOfRange(values, 0, num - i), sum);
        }
        Arrays.sort(array);
        System.out.println(array[0]);
    }
    public static int func1(int[] values, int sum) {
        int total = 0;
        int count = 0;
        int discount = 1;
        // solve
        while (true) {
            for (int i = values.length - discount; i >= 0; i--) {
                total += values[i];
                count++;
                if (total == sum) {
                    return count;
                } else if (total > sum) {
                    if (i == 0) {
                        total -= values[i];
                        total -= values[values.length - discount];
                        count -= 2;
                        if (discount == values.length) {
                            return -1;
                        }
                        discount++;
                        break;
                    }
                    count--;
                    total -= values[i];
                } else {
                    break;
                }
            }
        }
    }
}
