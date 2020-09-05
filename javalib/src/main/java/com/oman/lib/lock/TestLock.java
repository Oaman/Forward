package com.oman.lib.lock;

import java.util.concurrent.locks.Lock;

public class TestLock {

    public static void main(String[] args) {
        Lock lock = new MySelfLock();
        for (int i = 0; i < 5; i++) {
            MyThread myThread = new MyThread(lock);
            myThread.start();
        }
    }
}


class MyThread extends Thread {
    Lock lock;

    public MyThread(Lock lock) {
        this.lock = lock;
    }

    @Override
    public void run() {
        lock.lock();
        try {
            Thread.sleep(1000);
            System.out.println(Thread.currentThread().getName());
        } catch (InterruptedException e) {
            e.printStackTrace();
        } finally {
            lock.unlock();
        }
    }
}

