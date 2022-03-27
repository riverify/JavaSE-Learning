package com.river.pool;

public class sumTask {
    
    
    public static void main(String[] args) {
        // 1.use loop to sum up
        int n = 100;
        int sum = 0;
        for (int i = 1; i <= n; i++) {
            sum += i;
        }
        System.out.println(sum);

        // 2.use ForkJoin
        // 2.1 create a pool


        // 2.2 give a task

        // 2.3 task connects to pool

        // 2.4 get result

        // 2.5 close pool
    }
}
