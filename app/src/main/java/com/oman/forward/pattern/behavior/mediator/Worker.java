package com.oman.forward.pattern.behavior.mediator;

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
