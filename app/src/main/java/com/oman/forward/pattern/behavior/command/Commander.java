package com.oman.forward.pattern.behavior.command;

public class Commander {
    /**
     * 调用者
     */
    private Command mCommand;

    public Commander(Command command) {
        mCommand = command;
    }

    public void action(){
        mCommand.exec();
    }
}
