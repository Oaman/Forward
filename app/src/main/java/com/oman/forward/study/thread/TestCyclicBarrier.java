package com.oman.forward.study.thread;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @author:ZhouJiang
 * @date:2020/3/27 09:18
 * @email:zhoujiang2012@163.com
 */
public class TestCyclicBarrier {
    public static void main(String[] args) {
        CyclicBarrier cyclicBarrier = new CyclicBarrier(2, new Runnable() {
            @Override
            public void run() {
                System.out.println("after finish waiting:"+Thread.currentThread().getName());
            }
        });
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread0 working");
                    Thread.sleep(1000);
                    System.out.println("thread0 work finished, waiting other");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i=0;i<4;i++){
                    System.out.println("thread0 work:"+i);
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("thread1 working");
                    Thread.sleep(2000);
                    System.out.println("thread1 work rest");
                    Thread.sleep(1000);
                    System.out.println("thread1 work finished, waiting other");
                    cyclicBarrier.await();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                for (int i=0;i<4;i++){
                    System.out.println("thread1 work:"+i);
                }
            }
        }).start();

    }
}
