package com.oman.forward.pattern.behavior.interpreter;

public class Test {
    public static void main(String[] args) {
        /**
         * 计算 2*30/10 的值
         */

        int result = new Divide().interpreter(new Context(new Multi().interpreter(new Context(2, 30)), 10));
        System.out.println(result);
    }
}
