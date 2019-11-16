package com.oman.forward.pattern.structure.bridge;

public class Test {
    public static void main(String[] args) {

        Bridge bridge = new MyBridge();

        /**
         * 桥接模式:
         *      就是把事物和其具体实现进行分离，使他们可以各自独立的变化
         *      桥接的用意是：将抽象化和实例化解耦，使二者可以独立变化
         *
         *  如果系统需要在抽象化和具体化组件之间增加更多的灵活性，避免在两个层次之间建立静态的继承关系，可以通过桥接模式将他们建立一个关联关系
         */
        IMakeFood makeFood1 = new Noodles();
        bridge.setIMakeFood(makeFood1);
        bridge.makeFood();

        IMakeFood makeFood2 = new Rice();
        bridge.setIMakeFood(makeFood2);
        bridge.makeFood();
    }
}
