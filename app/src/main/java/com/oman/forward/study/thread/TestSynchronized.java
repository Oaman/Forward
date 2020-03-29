package com.oman.forward.study.thread;

/**
 * @author:ZhouJiang
 * @date:2020/3/27 18:45
 * @email:zhoujiang2012@163.com
 */
public class TestSynchronized {

    public void synMethod(Thread thread) {
        synchronized (this) {

        }
    }

    public void synMethod1(Thread thread) {
        synchronized (TestSynchronized.class) {

        }
    }

    public void synMethod2(Thread thread) {

    }


    public synchronized void synMethod3(Thread thread) {

    }

    public static synchronized void synMethod4(Thread thread) {

    }

}
