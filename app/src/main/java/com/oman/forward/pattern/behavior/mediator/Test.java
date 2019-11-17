package com.oman.forward.pattern.behavior.mediator;

public class Test {
    public static void main(String[] args) {

        /**
         * 中介者模式：IMediator扮演一个中介者或者调停者的角色
         *      如果不采用中介者模式的话，需要user1 user2二者相互引用，耦合度较高；
         *      使用中介者模式后，只需要维护好他们和Mediator的关系就好，大大降低耦合性
         */

        IMediator mediator = new Mediator();
        mediator.makeWorker();
        mediator.work();
    }
}
