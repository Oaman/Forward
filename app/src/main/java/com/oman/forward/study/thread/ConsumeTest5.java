package com.oman.forward.study.thread;

import java.util.ArrayList;

/**
 * @author:ZhouJiang
 * @date:2020/3/23 18:22
 * @email:zhoujiang2012@163.com
 */
public class ConsumeTest5 {

    public static void main(String[] args) {
        QueueClass queue = new QueueClass();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    queue.consume();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    queue.product();
                }
            }
        }).start();
    }

    static class QueueClass {
        private final ArrayList<String> list = new ArrayList<>(5);

        public void consume() {
            synchronized (list) {
                if (list.size() == 0) {
                    try {
                        System.out.println("size = 0, consume wait");
                        list.wait();
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
                list.notify();
            }
        }

        public void product() {
            synchronized (list) {
                if (list.size() == 5) {
                    try {
                        System.out.println("size = 5, product wait");
                        list.wait();
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
                list.notify();
            }
        }
    }

}

