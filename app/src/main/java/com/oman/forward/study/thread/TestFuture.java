package com.oman.forward.study.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.FutureTask;

/**
 * @author:ZhouJiang
 * @date:2020/3/27 08:54
 * @email:zhoujiang2012@163.com
 */
public class TestFuture {
    public static void main(String[] args) {
        Callable<String> callable = new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    System.out.println("sleep before:"+Thread.currentThread().getName());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("sleep after"+Thread.currentThread().getName());
                return "result";
            }
        };

        Future future = Executors.newSingleThreadExecutor().submit(callable);
        try {
            System.out.println(future.get());
        } catch (ExecutionException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("finally");
    }
}
