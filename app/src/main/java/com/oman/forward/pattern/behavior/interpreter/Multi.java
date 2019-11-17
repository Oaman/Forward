package com.oman.forward.pattern.behavior.interpreter;

public class Multi implements Interpreter {
    @Override
    public int interpreter(Context context) {
        return context.getNum1() * context.getNum2();
    }
}
