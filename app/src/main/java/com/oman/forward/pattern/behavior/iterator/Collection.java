package com.oman.forward.pattern.behavior.iterator;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 10:54
 * @email:zhoujiang2012@163.com
 */
public interface Collection<E> {

    Iterator<E> iterator();

    int size();

    E get(int position);
}
