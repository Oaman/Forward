package com.oman.lib;

import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeoutException;

public class SemaphoreTest {
    //信号量测试 只有三个信号可用  用来控制不要多个线程访问
    //CountDownLatch是用来控制当
    private static Semaphore semaphore = new Semaphore(3);

    public static void main(String[] args) throws InterruptedException, ExecutionException, TimeoutException {

        ExecutorService service = Executors.newFixedThreadPool(50);
        for (int i = 0; i < 1000; i++) {
            service.submit(new R());
        }


    }

    static class R implements Runnable {

        @Override
        public void run() {
            try {
                semaphore.acquire();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "获取了许可证");
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("执行慢服务--"+Thread.currentThread().getName() + "释放了许可证");
            semaphore.release();
        }
    }
}
