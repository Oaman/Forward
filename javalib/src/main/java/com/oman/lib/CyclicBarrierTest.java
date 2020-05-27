package com.oman.lib;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

/**
 * @author:ZhouJiang
 * @date:2020/5/27 10:00
 * @email:zhoujiang2012@163.com
 */
public class CyclicBarrierTest {
    /**
     * 作用对象不同：CyclicBarrier 要等固定数量的线程都到达了栅栏位置才能继续执行，而 CountDownLatch 只需等待数字倒数到 0，
     *          也就是说 CountDownLatch 作用于事件，但 CyclicBarrier 作用于线程；CountDownLatch
     *          是在调用了 countDown 方法之后把数字倒数减 1，而 CyclicBarrier 是在某线程开始等待后把计数减 1。
     * 可重用性不同：CountDownLatch 在倒数到 0  并且触发门闩打开后，就不能再次使用了，除非新建一个新的实例；而 CyclicBarrier
     *          可以重复使用，在刚才的代码中也可以看出，每 3 个同学到了之后都能出发，并不需要重新新建实例。CyclicBarrier
     *          还可以随时调用 reset 方法进行重置，如果重置时有线程已经调用了 await 方法并开始等待，那么这些线程则会抛出 BrokenBarrierException 异常。
     * 执行动作不同：CyclicBarrier 有执行动作 barrierAction，而 CountDownLatch 没这个功能。
     */
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3, new Runnable() {
            @Override
            public void run() {
                System.out.println("3个人数齐了，出发");
            }
        });
        for (int i = 0; i < 6; i++) {
            new Thread(new MyRunnable(i, barrier)).start();
        }
    }

    static class MyRunnable implements Runnable {
        int id;
        CyclicBarrier mBarrier;

        public MyRunnable(int id, CyclicBarrier barrier) {
            this.id = id;
            mBarrier = barrier;
        }

        @Override
        public void run() {
            System.out.println("同学" + id + "出发去大门");
            try {
                Thread.sleep((long) (Math.random() * 10000));
                System.out.println("同学" + id + "到达了车站");
                mBarrier.await();
                System.out.println("同学" + id + "开始骑车");
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }
}
