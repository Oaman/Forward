package com.oman.forward.pattern.structure.bridge;

public abstract class Bridge {
    IMakeFood mIMakeFood;

    public void makeFood() {
        mIMakeFood.makeFood();
    }

    public IMakeFood getIMakeFood() {
        return mIMakeFood;
    }

    public void setIMakeFood(IMakeFood IMakeFood) {
        mIMakeFood = IMakeFood;
    }
}
