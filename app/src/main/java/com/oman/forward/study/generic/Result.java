package com.oman.forward.study.generic;

/**
 * @author:ZhouJiang
 * @date:2020/5/16 20:29
 * @email:zhoujiang2012@163.com
 */
public class Result<T> {
    private T data;
    private int code;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }
}
