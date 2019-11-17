package com.oman.forward.pattern.behavior.iterator;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 10:56
 * @email:zhoujiang2012@163.com
 */
public class MyCollection<E> implements Collection<E> {
    private E[] data;

    public MyCollection(E[] data) {
        this.data = data;
    }

    @Override
    public Iterator<E> iterator() {
        return new MyIterator<>(this);
    }

    @Override
    public int size() {
        return data.length;
    }

    @Override
    public E get(int position) {
        return data[position];
    }
}
