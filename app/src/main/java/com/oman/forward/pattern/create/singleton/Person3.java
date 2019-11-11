package com.oman.forward.pattern.create.singleton;

/**
 * @author:ZhouJiang
 * @date:2019/11/11 22:41
 * @email:zhoujiang2012@163.com
 */
public class Person3 {
    /**
     * 加锁固然解决了我们的问题，但是这样效率就低了很多，并且锁还是在方法上加的，因为同步方法比同步代码块效率低的多
     */
    private static Person3 INSTANCE = null;

    private Person3() {
    }

    public synchronized static Person3 getInstance() {
        if (null == INSTANCE) {
            INSTANCE = new Person3();
        }
        return INSTANCE;
    }
}
