package com.oman.forward.study;

import java.util.concurrent.ArrayBlockingQueue;

/**
 * @author:ZhouJiang
 * @date:2020/3/23 18:22
 * @email:zhoujiang2012@163.com
 */
public class ConsumeTest4 {

    private static final ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(5);

    public static void main(String[] args) {
        new Thread(new ConsumerImpl(), "consume thread").start();
        new Thread(new ProductImpl(), "product thread").start();
    }

    static class ConsumerImpl implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    String removeName = queue.take();
                    System.out.println("消费了：" + removeName + "--剩余产品数量：" + queue.size());
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    static class ProductImpl implements Runnable {

        @Override
        public void run() {
            while (true) {
                try {
                    String name = "product:" + (queue.size() + 1);
                    queue.put(name);
                    System.out.println("添加了产品：" + name + "--剩余空间：" + (5 - queue.size()));
                    Thread.sleep(1100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

