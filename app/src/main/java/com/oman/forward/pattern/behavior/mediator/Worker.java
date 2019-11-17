package com.oman.forward.pattern.behavior.mediator;

/**
 * @author：ZhouJiang
 * @date：2018/2/1 17:03
 * @email：zhoujiang2012@163.com
 */

public abstract class Worker {

    private IMediator mMediator;

    public Worker(IMediator mediator) {
        mMediator = mediator;
    }

    public IMediator getMediator() {
        return mMediator;
    }

    public void setMediator(IMediator mediator) {
        mMediator = mediator;
    }
    public abstract void work();
}
