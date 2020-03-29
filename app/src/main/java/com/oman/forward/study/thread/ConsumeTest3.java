package com.oman.forward.study.thread;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author:ZhouJiang
 * @date:2020/3/23 18:22
 * @email:zhoujiang2012@163.com
 */
public class ConsumeTest3 {

    private static final ArrayList<String> list = new ArrayList<>(5);
    private static Lock lock = new ReentrantLock();
    private static Condition product = lock.newCondition();
    private static Condition consume = lock.newCondition();

    public static void main(String[] args) {
        new Thread(new ConsumerImpl(), "consume thread").start();
        new Thread(new ProductImpl(), "product thread").start();
    }

    static class ConsumerImpl implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (list.size() == 0) {
                        try {
                            System.out.println("size = 0, consume wait");
                            consume.await();
                            System.out.println("consume wait finish");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String removeName = list.remove(0);
                    System.out.println("消费了：" + removeName + "--剩余产品数量：" + list.size());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    product.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }

    static class ProductImpl implements Runnable {

        @Override
        public void run() {
            while (true) {
                lock.lock();
                try {
                    if (list.size() == 5) {
                        try {
                            System.out.println("size = 5, product wait");
                            product.await();
                            System.out.println("product wait finish");
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                    String name = "product:" + (list.size() + 1);
                    list.add(name);
                    System.out.println("添加了产品：" + name + "--剩余空间：" + (5 - list.size()));
                    try {
                        Thread.sleep(1100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    consume.signal();
                } finally {
                    lock.unlock();
                }
            }
        }
    }
}

