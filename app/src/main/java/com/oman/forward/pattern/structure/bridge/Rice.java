package com.oman.forward.pattern.structure.bridge;

public class Rice implements IMakeFood {
    @Override
    public void makeFood() {
        System.out.println("做的是米饭");
    }
}
