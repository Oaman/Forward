package com.oman.forward.pattern.behavior.memento;

public class Storage {
    private Memento mMemo;

    public Storage(Memento memo) {
        mMemo = memo;
    }

    public Memento getMemo() {
        return mMemo;
    }

    public void setMemo(Memento memo) {
        mMemo = memo;
    }
}
