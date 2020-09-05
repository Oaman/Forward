package com.oman.lib.structure;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.RejectedExecutionHandler;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class TestThreadPool {
    public static void main(String[] args) {
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3, 6, 10, TimeUnit.SECONDS,
                new ArrayBlockingQueue<>(10), Executors.defaultThreadFactory(), new RejectedExecutionHandler() {
            @Override
            public void rejectedExecution(Runnable r, ThreadPoolExecutor e) {
                if (r instanceof MyRunnable) {
                    System.out.println("======reject i: " + ((MyRunnable) r).i);
                }
                if (!e.isShutdown()) {
                    r.run();
                }
            }
        });
        for (int i = 1; i <= 20; i++) {
            executor.execute(new MyRunnable(i));
        }
    }


    static class MyRunnable implements Runnable {
        public int i;

        public MyRunnable(int i) {
            this.i = i;
        }

        @Override
        public void run() {
            try {
                System.out.println("start runnable:" + i + "--thread:" + Thread.currentThread().getName());
                Thread.sleep(2000);
                System.out.println("runnable:" + i + "--thread:" + Thread.currentThread().getName());
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
