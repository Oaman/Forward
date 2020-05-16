package com.oman.forward.study.rxjava;

import com.oman.forward.study.jdk.Button;

/**
 * @author:ZhouJiang
 * @date:2020/5/11 19:14
 * @email:zhoujiang2012@163.com
 */
public class Test {
    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(string -> {
            System.out.println(string);
        });
    }
}
