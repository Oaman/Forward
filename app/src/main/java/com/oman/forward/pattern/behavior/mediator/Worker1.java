package com.oman.forward.pattern.behavior.mediator;

public class Worker1 extends Worker {

    public Worker1(IMediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("work1 exec");
    }
}
