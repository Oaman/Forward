package com.oman.forward.pattern.behavior.strategy;

public class Strategy1 implements Strategy {

    StringBuilder builder = new StringBuilder("select * from user where ");

    @Override
    public String getSQL(String[] names) {
        if (names != null && names.length != 0) {
            for (String s : names) {
                builder.append("name = ").append(s).append(" or ");
            }
        }
        builder.delete(builder.length() - 4, builder.length());
        return builder.toString();
    }
}
