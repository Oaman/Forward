package com.oman.forward.pattern.behavior.command;

public class Test {
    public static void main(String[] args) {
        /**
         * 命令模式：
         *      命令模式的目的就是达到命令的发出者和执行者之间解耦，实现请求和执行分开
         *
         * 司令员发出指令  经过传递到士兵  士兵执行
         */

        Solider solider = new Solider();
        Command command = new MyCommand(solider);
        Commander commander = new Commander(command);
        commander.action();
    }
}
