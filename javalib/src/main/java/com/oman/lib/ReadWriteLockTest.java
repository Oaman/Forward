package com.oman.lib;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 16:10
 * @email:zhoujiang2012@163.com
 */
public class ReadWriteLockTest {
    private static final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock(false);
    private static final ReentrantReadWriteLock.ReadLock readLock = readWriteLock.readLock();
    private static final ReentrantReadWriteLock.WriteLock writeLock = readWriteLock.writeLock();

    private static void read() {
        readLock.lock();
        try {
            System.out.println("get read lock");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            readLock.unlock();
            System.out.println("release read lock");
        }
    }

    private static void write() {
        writeLock.lock();
        try {
            System.out.println("get write lock");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            writeLock.unlock();
            System.out.println("release write lock");
        }
    }

    public static void main(String[] args) {
        new Thread(ReadWriteLockTest::read).start();
        new Thread(ReadWriteLockTest::read).start();
        new Thread(ReadWriteLockTest::write).start();
        new Thread(ReadWriteLockTest::write).start();
    }
}
