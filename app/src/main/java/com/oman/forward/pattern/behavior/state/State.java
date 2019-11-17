package com.oman.forward.pattern.behavior.state;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 13:16
 * @email:zhoujiang2012@163.com
 */
public class State {
    private String methodName;

    public String getMethodName() {
        return methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }

    void login(){
        System.out.println("exec login");
    }

    void logout(){
        System.out.println("exec logout");
    }
}
