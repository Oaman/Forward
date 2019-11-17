package com.oman.forward.pattern.behavior.visitor;

public class Visitor implements IVisitor {
    @Override
    public void visit(ISubject subject) {
        System.out.println("visit the subject：" + subject.getSubject());
    }
}
