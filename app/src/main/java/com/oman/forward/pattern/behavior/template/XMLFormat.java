package com.oman.forward.pattern.behavior.template;

public class XMLFormat extends Formatter {
    @Override
    protected void formatting(Book book) {
        String result = "";
        result += "<book_name>" + book.getName() + "</book_name>\n";
        result += "<price>" + book.getPrice() + "</price>";
        System.out.println(result);
    }
}
