package com.oman.lib.structure;

import java.util.Arrays;

import kotlin.Suppress;

public class MyArrayList<E> {

    int size;

    private Object[] elements;

    private static final int DEFAULT_CAPACITY = 10;

    private static final Object[] DEFAULT_EMPTY_ELEMENTS = {};

    public MyArrayList() {
        elements = DEFAULT_EMPTY_ELEMENTS;
    }

    public MyArrayList(int initialCapacity) {
        if (initialCapacity > 0) {
            elements = new Object[initialCapacity];
        } else if (initialCapacity == 0) {
            elements = new Object[DEFAULT_CAPACITY];
        } else {
            throw new IllegalArgumentException("illegal arguments:" + initialCapacity);
        }
    }

    /**
     * add
     */

    public boolean add(E e) {
        if (elements == DEFAULT_EMPTY_ELEMENTS) {
            elements = new Object[DEFAULT_CAPACITY];
        }
        if (size + 1 > elements.length) {
            growCapacity(size + 1);
        }
        elements[size++] = e;
        return true;
    }

    /**
     * add(index,e)  add(2,6)在2号位置插入元素6
     * 1,2,3,4,5  1,2,6,3,4,5
     */
    public boolean add(int index, E e) {
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        if (elements == DEFAULT_EMPTY_ELEMENTS) {
            elements = new Object[DEFAULT_CAPACITY];
        }
        if (size + 1 > elements.length) {
            growCapacity(size + 1);
        }
        System.arraycopy(elements, index, elements, index + 1, size - index);
        elements[index] = e;
        size++;
        return true;
    }

    /**
     * get
     */
    @SuppressWarnings("unchecked")
    public E get(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        return (E) elements[index];
    }

    /**
     * remove  0,1,2
     */
    @SuppressWarnings("unchecked")
    public E remove(int index) {
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("illegal index:" + index);
        }
        E oldValue = (E) elements[index];
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[--size] = null;
        return oldValue;
    }

    @SuppressWarnings("unchecked")
    public boolean remove(Object o) {
        if (o == null) {
            for (int i = 0; i < size; i++) {
                if (elements[i] == null) {
                    fastRemove(i);
                    return true;
                }
            }
        } else {
            for (int i = 0; i < size; i++) {
                if (o.equals(elements[i])) {
                    fastRemove(i);
                    return true;
                }
            }
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    private void fastRemove(int index) {
        int numMoved = size - index - 1;
        if (numMoved > 0)
            System.arraycopy(elements, index + 1, elements, index, numMoved);
        elements[--size] = null;
    }

    private void growCapacity(int minCapacity) {
        int oldCapacity = elements.length;
        int newCapacity = oldCapacity + (oldCapacity >> 1);//Need use () here
        if (newCapacity < minCapacity)
            newCapacity = minCapacity;
        elements = Arrays.copyOf(elements, newCapacity);
    }

    public String toString() {
        return Arrays.toString(elements);
    }

    public static void main(String[] args) {
        MyArrayList<Integer> list = new MyArrayList<>();
        list.add(1);
        list.add(2);
        list.add(5);
        list.add(6);
        list.add(7);
        list.add(8);
        list.add(9);
        list.add(10);
        list.add(11);
        list.add(12);
        list.add(13);
        list.add(14);
        list.add(15);
        list.add(16);
        System.out.println(list.toString());
        System.out.println(list.elements.length);
        list.add(2, 3);
        System.out.println(list.toString());
        list.add(3, 4);
        System.out.println(list.toString());

        //TODO get
        System.out.println(list.size);
        System.out.println(list.get(3));

        //TODO remove
        System.out.println(list.remove(2));
        System.out.println(list.toString());
        System.out.println(list.remove(2));

    }
}
