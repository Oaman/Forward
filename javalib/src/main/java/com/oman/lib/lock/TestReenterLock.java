package com.oman.lib.lock;

import java.util.concurrent.locks.Lock;

public class TestReenterLock {
    //    static Lock lock = new MySelfLock();
    static Lock lock = new MyReenterSelfLock();

    /**
     * 独享锁如果不可重入的话就会自己锁死自己
     */
    public static void main(String[] args) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                testReenter(3);
            }
        }).start();
    }

    static void testReenter(int times) {
        lock.lock();
        try {
            System.out.println("递归层级：" + times);
            times--;
            if (times == 0) return;
            testReenter(times);
        } finally {
            lock.unlock();
        }
    }


}
