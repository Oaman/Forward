package com.oman.forward.pattern.behavior.state;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 13:17
 * @email:zhoujiang2012@163.com
 */
public class Context {
    private State state;

    public Context(State state) {
        this.state = state;
    }

    public void operator() {
        if (state.getMethodName().equals("login")) {
            state.login();
        } else if (state.getMethodName().equals("logout")) {
            state.logout();
        }
    }
}
