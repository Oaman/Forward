package com.oman.forward.study.byteinsert;

public class ByteInsert {

    @Deprecated
    public void needInsertMethod() {
        //sleep 3 seconds to monitor do some work
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void normalMethod() {

    }
}


