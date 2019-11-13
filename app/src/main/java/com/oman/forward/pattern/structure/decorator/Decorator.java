package com.oman.forward.pattern.structure.decorator;

public class Decorator implements Sourceable {
    private Sourceable source;

    public Decorator(Sourceable source) {
        this.source = source;
    }

    @Override
    public void method() {
        beforeMethod();
        source.method();
        afterMethod();
    }

    private void beforeMethod() {
        System.out.println("before decorator");
    }

    private void afterMethod() {
        System.out.println("after decorator");
    }
}
