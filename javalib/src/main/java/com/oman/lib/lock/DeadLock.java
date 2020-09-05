package com.oman.lib.lock;

public class DeadLock {
    private static Object No13 = new Object();//第一个锁
    private static Object No14 = new Object();//第一个锁

    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (No13) {
                    try {
                        System.out.println("thread 1 get 13");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (No14) {
                        System.out.println("thread 1 get 14");
                    }
                }
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (No14) {
                    try {
                        System.out.println("thread 2 get 14");
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    synchronized (No13) {
                        System.out.println("thread 2 get 13");
                    }
                }
            }
        }).start();
    }
}
