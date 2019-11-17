package com.oman.forward.pattern.behavior.iterator;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 10:54
 * @email:zhoujiang2012@163.com
 */
public interface Iterator<E> {

    boolean hasNext();

    E next();
}
