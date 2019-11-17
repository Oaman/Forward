package com.oman.forward.pattern.behavior.visitor;

public interface ISubject {

    void accept(IVisitor visitor);
    String getSubject();
}
