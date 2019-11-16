package com.oman.forward.pattern.behavior.template;

public class Test {

    public static void main(String[] args) {
        /**
         * 需求：根据一个对象打印出不同的数据格式： JSON或者XML格式的数据
         *
         * 模板方法模式
         * 定义一个操作中的算法的骨架，而将一些步骤延迟到子类中，模板方法使得子类可以不改变一个算法的结构即可重定义该算法的某些特定步骤。
         * 只能被替换其中的点
         */
        Book book = new Book();
        book.setName("平凡的世界");
        book.setPrice(88);

//        new JsonFormat().formatBook(book);

        new XMLFormat().formatBook(book);
    }
}
