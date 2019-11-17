package com.oman.forward.pattern.behavior.mediator;

public class Worker2 extends Worker {
    public Worker2(IMediator mediator) {
        super(mediator);
    }

    @Override
    public void work() {
        System.out.println("work2 exec");
    }
}
