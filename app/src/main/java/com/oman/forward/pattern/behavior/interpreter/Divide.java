package com.oman.forward.pattern.behavior.interpreter;

public class Divide implements Interpreter {
    @Override
    public int interpreter(Context context) {
        return context.getNum1() / context.getNum2();
    }
}
