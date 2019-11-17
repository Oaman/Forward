package com.oman.forward.pattern.behavior.memento;

public class Test {
    public static void main(String[] args) {
        /**
         * 备忘录模式：
         *      将新值赋值给Memo之后，value的值就是原始的，所以后来可以恢复，备忘录
         */

        Original original = new Original("原始信息");

        Storage storage = new Storage(original.createMemo());

        System.out.println("原始值：" + original.getValue());
        original.setValue("新的值");
        System.out.println("新的值：" + original.getValue());

        original.restoreMemo(storage.getMemo());
        System.out.println("恢复后的原始值：" + original.getValue());
    }
}
