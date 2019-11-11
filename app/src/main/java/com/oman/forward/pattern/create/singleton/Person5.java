package com.oman.forward.pattern.create.singleton;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:43
 * @email:zhoujiang2012@163.com
 */
public class Person5 {
    /**
     * Double-Check Locking 双重锁定单例模式
     */
    private static Person5 INSTANCE = null;

    private Person5() {
    }

    /**
     * 在执行INSTANCE = new Person5();这一行的时候，因为不是原子性操作，所以是分步进行的，又如下三个步骤：
     * 1 分配对象的内存空间
     * 2 初始化对象
     * 3 将INSTANCE指向刚分配的内存地址
     *
     * 我们都知道重排序，就是创建对象和赋值操作，JVM不保证执行顺序，那如果先执行3再执行2，就会出问题了，比如有两个线程A和B：
     *
     *  A和B同时进入了1处的if判断；
     *  A首先获取了锁，分配内存有了地址值，但是还没有来得及在堆中实例化
     *  B线程判断了不为空，这个时候就会返回对象到方法的调用处，这个时候因为对象还没有实例化，就会出错。
     */
    public static Person5 getInstance() {
        if (INSTANCE == null) {    // 1
            synchronized (Person5.class) {
                if (INSTANCE == null) {
                    INSTANCE = new Person5();  //2
                }
            }
        }
        return INSTANCE;
    }
}
