package com.oman.lib.structure;

public class ThreadTest {

    static Object object = new Object();

    public static void main(String[] args) throws InterruptedException {
        /*//notify
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (object) {
                    System.out.println(Thread.currentThread().getName() + " get lock execute wait"+"--"+Thread.currentThread().isInterrupted());
                    try {
                        object.wait();
                        System.out.println(Thread.currentThread().getName() + " wait finish"+Thread.currentThread().isInterrupted());
                    } catch (InterruptedException e) {
                        System.out.println(Thread.currentThread().getName() + " exception"+Thread.currentThread().isInterrupted());
                        e.printStackTrace();
                    }
                    System.out.println(Thread.currentThread().getName() + " last "+Thread.currentThread().isInterrupted());
                }
            }
        }, "thread-1");
        thread1.start();

////        Thread thread3 = new Thread(new Runnable() {
////            @Override
////            public void run() {
////                synchronized (object) {
////                    System.out.println(Thread.currentThread().getName() + " get lock execute wait"+"--"+Thread.currentThread().isInterrupted());
////                    try {
////                        object.wait();
////                        System.out.println(Thread.currentThread().getName() + " wait finish"+Thread.currentThread().isInterrupted());
////                    } catch (InterruptedException e) {
////                        System.out.println(Thread.currentThread().getName() + " exception"+Thread.currentThread().isInterrupted());
////                        e.printStackTrace();
////                    }
////                }
////            }
////        }, "thread-3");
////        thread3.start();
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                synchronized (object) {
//                    System.out.println(Thread.currentThread().getName() + " get lock execute notify");
//                    try {
////                        thread1.interrupt();
//                        object.notify();
////                        object.notifyAll();
//                        System.out.println(Thread.currentThread().getName() + " notify finish");
//                    } catch (Exception e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }, "thread-2");
//        thread2.start();

        Thread.sleep(3000);
//        System.out.println(thread1.getState());
//        System.out.println(thread2.getState());
//        System.out.println(thread3.getState());
        thread1.interrupt();*/

/*
//sleep
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                System.out.println("outer interrupt:" + Thread.currentThread().isInterrupted());
                while (!Thread.currentThread().isInterrupted()) {
                    try {
                        Thread.sleep(1000);
                        System.out.println("count:" + count++ + "--interrupt:" + Thread.currentThread().isInterrupted());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println("last interrupt:" + Thread.currentThread().isInterrupted());
            }
        });
        thread.start();

        Thread.sleep(1100);
        thread.interrupt();
        System.out.println("finish");*/

/*
//        //join
        Thread thread1 = new Thread(new Runnable() {
            @Override
            public void run() {
                int count = 0;
                while (!Thread.currentThread().isInterrupted() && count < 10) {
                    try {
                        Thread.sleep(1000);
                        System.out.println(Thread.currentThread().getName() + "-number:" + count++ + Thread.currentThread().isInterrupted());
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                        System.out.println(Thread.currentThread().getName() + " exception" + Thread.currentThread().isInterrupted());
                        Thread.currentThread().interrupt();
                    }
                }
                System.out.println(Thread.currentThread().getName() + "-last:" + Thread.currentThread().isInterrupted());
            }
        }, "thread1");
        thread1.start();
//
//        Thread thread2 = new Thread(new Runnable() {
//            @Override
//            public void run() {
//                int count = 0;
//                while (!Thread.currentThread().isInterrupted() && count < 5) {
//                    try {
//                        thread1.join();
//                        Thread.sleep(1000);
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                    System.out.println(Thread.currentThread().getName() + "-number:" + count++);
//                }
//            }
//        },"thread2");
//        thread2.start();

        Thread.sleep(3000);
        thread1.interrupt();
        System.out.println("finish");*/




    }
}
