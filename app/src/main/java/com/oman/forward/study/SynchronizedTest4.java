package com.oman.forward.study;

/**
 * @author:ZhouJiang
 * @date:2020/3/23 21:45
 * @email:zhoujiang2012@163.com
 */
public class SynchronizedTest4 {
    static class Thread1 extends Thread {
        @Override
        public void run() {
            super.run();
            Utils.method1();
        }
    }

    static class Thread2 extends Thread {

        @Override
        public void run() {
            super.run();
            Utils.method2();
        }
    }

    static class Utils {
        synchronized static void method1() {
            System.out.println("method1 exec before -- threadName:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method1 exec after-- threadName:" + Thread.currentThread().getName());
        }

        synchronized static void method2() {
            System.out.println("method2 exec before -- threadName:" + Thread.currentThread().getName());
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("method2 exec after-- threadName:" + Thread.currentThread().getName());
        }
    }

    //synchronized静态方法加锁, 同步
    public static void main(String[] args) {
        new Thread1().start();
        new Thread2().start();
    }
}


