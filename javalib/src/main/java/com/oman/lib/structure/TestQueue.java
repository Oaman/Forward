package com.oman.lib.structure;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.Stack;
import java.util.concurrent.ArrayBlockingQueue;

public class TestQueue {
    public static void main(String[] args) throws Exception {
        System.out.println("---------Stack------------");
        Stack<String> stack = new Stack<>();
        stack.push("11");
        stack.push("22");
        stack.push("33");
        System.out.println(stack.pop());
        System.out.println(stack.lastElement());
        Field elementCount = stack.getClass().getSuperclass().getDeclaredField("elementCount");
        elementCount.setAccessible(true);
        System.out.println(elementCount.get(stack));
        System.out.println("-----------ArrayBlockingQueue----------");
        ArrayBlockingQueue<String> queue = new ArrayBlockingQueue<>(2);
        queue.add("first");
//        queue.add("first");
        Field items = queue.getClass().getDeclaredField("items");
        items.setAccessible(true);
        System.out.println(((Object[]) items.get(queue)).length);

        Field count = queue.getClass().getDeclaredField("count");
        count.setAccessible(true);
        System.out.println(count.get(queue));

        Field putIndex = queue.getClass().getDeclaredField("putIndex");
        putIndex.setAccessible(true);
        System.out.println(putIndex.get(queue));

        Field takeIndex = queue.getClass().getDeclaredField("takeIndex");
        takeIndex.setAccessible(true);
        System.out.println(takeIndex.get(queue));


    }
}
