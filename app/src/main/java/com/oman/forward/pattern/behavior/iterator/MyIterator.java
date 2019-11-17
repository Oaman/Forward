package com.oman.forward.pattern.behavior.iterator;

/**
 * @author:ZhouJiang
 * @date:2019/11/17 10:57
 * @email:zhoujiang2012@163.com
 */
public class MyIterator<E> implements Iterator<E> {

    private Collection<E> mCollection;

    private int position = -1;

    public MyIterator(Collection<E> collection) {
        mCollection = collection;
    }

    @Override
    public boolean hasNext() {
        return position < mCollection.size() - 1;
    }

    @Override
    public E next() {
        if (position < mCollection.size() - 1) {
            position++;
        }
        return mCollection.get(position);
    }
}
