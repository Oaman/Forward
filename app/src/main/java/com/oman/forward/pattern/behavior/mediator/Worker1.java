package com.oman.forward.pattern.behavior.mediator;

/**
 * @author：ZhouJiang
 * @date：2018/2/1 17:04
 * @email：zhoujiang2012@163.com
 */

public class Worker1 extends Worker {

    public Worker1(IMediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("work1 exec");
    }
}
