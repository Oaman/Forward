package com.oman.forward.pattern.behavior.mediator;

/**
 * @author：ZhouJiang
 * @date：2018/2/1 17:04
 * @email：zhoujiang2012@163.com
 */

public class Worker2 extends Worker {
    public Worker2(IMediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("work2 exec");
    }
}
