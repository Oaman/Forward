package com.oman.forward.study;

/**
 * @author:ZhouJiang
 * @date:2020/3/23 21:45
 * @email:zhoujiang2012@163.com
 */
public class SynchronizedTest3 {
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
            synchronized (Utils.class) {
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
            synchronized (Utils.class) {
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

    //synchronized(xxx.class)加锁, 不管线程中传入的是不是同一个对象，都是同步
    public static void main(String[] args) {
        Utils utils = new Utils();
        Utils utils2 = new Utils();
        Thread thread1 = new Thread1(utils);
        Thread thread2 = new Thread2(utils2);
        thread1.start();
        thread2.start();
    }
}


