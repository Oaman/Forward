package com.oman.forward.study.thread;

/**
 * @author:ZhouJiang
 * @date:2020/3/23 21:45
 * @email:zhoujiang2012@163.com
 */
public class SynchronizedTest2 {
    static class Thread1 extends Thread {
        Utils mUtils;

        Thread1(Utils utils) {
            mUtils = utils;
        }

        @Override
        public void run() {
            super.run();
            mUtils.method1();
        }
    }

    static class Thread2 extends Thread {
        Utils mUtils;

        Thread2(Utils utils) {
            mUtils = utils;
        }

        @Override
        public void run() {
            super.run();
            mUtils.method2();
        }
    }

    static class Utils {
        void method1() {
            synchronized (Utils.this) {
                System.out.println("method1 exec before -- threadName:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("method1 exec after-- threadName:" + Thread.currentThread().getName());
            }
        }

        void method2() {
            synchronized (Utils.this) {
                System.out.println("method2 exec before -- threadName:" + Thread.currentThread().getName());
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("method2 exec after-- threadName:" + Thread.currentThread().getName());
            }
        }
    }

    //synchronized(this)代码块加锁,传入同一个对象是同步，如果传入的不是同一个对象就是异步
    public static void main(String[] args) {
        Utils utils = new Utils();
        Utils utils2 = new Utils();
        Thread thread1 = new Thread1(utils);
        Thread thread2 = new Thread2(utils2);
        thread1.start();
        thread2.start();
    }
}


