package com.oman.forward.study.rxjava;

/**
 * @author:ZhouJiang
 * @date:2020/5/11 19:06
 * @email:zhoujiang2012@163.com
 */
public class Button {
    public void setOnClickListener(ButtonClickListener listener){
        listener.onClick("view");
    }
}
