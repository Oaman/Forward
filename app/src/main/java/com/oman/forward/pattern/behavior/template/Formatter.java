package com.oman.forward.pattern.behavior.template;

public abstract class Formatter {

    public void formatBook(Book book) {
        beforeFormat();
        formatting(book);
        afterFormat();
    }

    /**
     * 需求：根据一个对象打印出不同的数据格式JSON或者XML格式的数据
     * @param book
     */
    protected abstract void formatting(Book book);

    private void beforeFormat() {
        System.out.println("beforeFormat");
    }

    private void afterFormat() {
        System.out.println("afterFormat");
        System.out.println("------------------");
    }

}
