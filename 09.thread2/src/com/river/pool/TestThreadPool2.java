package com.river.pool;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.*;

/**
 * 使用线程池执行大量的Callable命令
 */
public class TestThreadPool2 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // create a thread pool
        // only one exit
        ExecutorService pool1 = Executors.newSingleThreadExecutor();
        // 10 fixed pools
        ExecutorService pool2 = Executors.newFixedThreadPool(10);
        // number of pools dynamically changes
        ExecutorService pool3 = Executors.newCachedThreadPool();
        // by schedule
        ExecutorService pool4 = Executors.newScheduledThreadPool(10);

        // use thread pool
        List<Future> futureList = new ArrayList<Future>();
        for (int i = 0; i < 20; i++) {
            // Callable task = new MyCallable();
            Callable<Integer> task = new Callable<Integer>() {
                @Override
                public Integer call() throws Exception {
                    Thread.sleep(3000);
                    return new Random().nextInt(10);
                }
            };
            Future<Integer> future = pool3.submit(task);
            futureList.add(future);
            //int result = future.get();
            //System.out.println(result);
        }
        for (int i = 0; i < 20; i++) {
            Future future = futureList.get(i);
            System.out.println(future.get());
        }
        // close
        pool3.shutdown();
    }
}

class MyCallable implements Callable<Integer> {

    @Override
    public Integer call() throws Exception {
        return new Random().nextInt(10);
    }
}