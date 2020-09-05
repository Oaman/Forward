package com.oman.lib.structure;

import java.util.List;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class TestScheduler {
    public static void main(String[] args) {
        ScheduledExecutorService executorService = Executors.newSingleThreadScheduledExecutor();
        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("first:"+Thread.currentThread().getName());
            }
        },5L, TimeUnit.SECONDS);

        executorService.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println("second:"+Thread.currentThread().getName());
            }
        },5L, TimeUnit.SECONDS);

//        try {
//            executorService.awaitTermination(5L,TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }

        List<Runnable> runnables = executorService.shutdownNow();
        System.out.println(runnables);

    }
}
