package com.oman.forward.pattern.behavior.command;

public class MyCommand implements Command {

    private Solider mSolider;

    public MyCommand(Solider solider) {
        mSolider = solider;
    }

    @Override
    public void exec() {
        mSolider.action();
    }
}
