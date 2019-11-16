package com.oman.forward.pattern.structure.bridge;

public class MyBridge extends Bridge {
    @Override
    public void makeFood() {
        getIMakeFood().makeFood();
    }
}
