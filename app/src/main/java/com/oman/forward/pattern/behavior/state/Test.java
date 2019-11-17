package com.oman.forward.pattern.behavior.state;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 13:19
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args) {
        /**
         *  当对象的状态改变时候，行为也跟着改变
         */
        State state = new State();
        Context context = new Context(state);

        state.setMethodName("login");
        context.operator();

        state.setMethodName("logout");
        context.operator();
    }
}
