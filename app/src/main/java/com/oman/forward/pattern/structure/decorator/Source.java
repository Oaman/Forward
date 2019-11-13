package com.oman.forward.pattern.structure.decorator;

public class Source implements Sourceable {
    @Override
    public void method() {
        System.out.println("this is original method");
    }
}
