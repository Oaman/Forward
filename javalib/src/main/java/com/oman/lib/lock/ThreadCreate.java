package com.oman.lib.lock;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;
import java.util.concurrent.ThreadPoolExecutor;

public class ThreadCreate {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        //线程
        ExecutorService service = Executors.newFixedThreadPool(3);
        Future<String> future = service.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "AAA";
            }
        });
        ThreadPoolExecutor executor;

        FutureTask<String> task = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                Thread.sleep(2000);
                return "BBB";
            }
        });
        service.execute(task);
        String s1 = task.get();
//        String s = future.get();
//        service.shutdown();
//        System.out.println(s);
        System.out.println(s1);
        System.out.println("main");
    }
}
