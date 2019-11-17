package com.oman.forward.pattern.behavior.visitor;

public class Subject implements ISubject {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }

    @Override
    public String getSubject() {
        return "LOVE";
    }
}
