package com.oman.forward.pattern.behavior.strategy;

public class Strategy2 implements Strategy {

    StringBuilder builder = new StringBuilder("select * from user where ");

    @Override
    public String getSQL(String[] names) {
        boolean needOr = false;
        /**
         * 此处使用boolean控制是否插入or字符
         * 将or放到最前面 先不添加or 添加一个之后将boolean值设置为true就可以添加or了
         * 或者将
         */
        for (String s : names) {
            if (needOr) {
                builder.append(" or ");
            }
            builder.append("name = ");
            builder.append(s);
            needOr = true;
        }
        return builder.toString();
    }
}
