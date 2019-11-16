package com.oman.forward.pattern.structure.bridge;

public class Noodles implements IMakeFood {
    @Override
    public void makeFood() {
        System.out.println("做的是面条");
    }
}
