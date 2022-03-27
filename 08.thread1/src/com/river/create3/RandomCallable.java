package com.river.create3;

import java.util.Random;
import java.util.concurrent.*;

public class RandomCallable implements Callable<Integer> {
    @Override
    public Integer call() throws Exception {  // 可以抛出检查异常
//        if () {
//            throw new Exception();
//        }
        Thread.sleep(6000);
        return new Random().nextInt(10);
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        // 创建一个进程对象
        Callable<Integer> callable = new RandomCallable();
        FutureTask<Integer> task = new FutureTask(callable);
        Thread thread = new Thread(task);
        // 启动线程
        thread.start();
        // 得到返回值
        System.out.println(task.isDone());
//        int result = task.get();  // 得不到返回值就一直等待
        int result = 0;
        try {
            result = task.get(3, TimeUnit.SECONDS);
        } catch (TimeoutException e) {
            e.printStackTrace();
        }
        System.out.println(task.isDone());
        System.out.println(result);

    }
}
