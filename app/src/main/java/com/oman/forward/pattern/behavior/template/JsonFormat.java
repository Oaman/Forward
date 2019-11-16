package com.oman.forward.pattern.behavior.template;

public class JsonFormat extends Formatter {
    @Override
    protected void formatting(Book book) {
        String result = "";
        result += "{\n";
        result += "\"book_name\" : \"" + book.getName() + "\",\n";
        result += "\"price\" : \"" + book.getPrice() + "\"\n";
        result += "}";
        System.out.println(result);
    }
}
