package com.oman.forward.pattern.behavior.mediator;

public class Mediator implements IMediator {
    private Worker1 mUser1;
    private Worker2 mUser2;

    @Override
    public void makeWorker() {
        mUser1 = new Worker1(this);
        mUser2 = new Worker2(this);
    }

    @Override
    public void work() {
        mUser1.work();
        mUser2.work();
    }
}
