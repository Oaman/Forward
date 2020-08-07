package com.oman.kotlin;

public abstract class Test {
    abstract void name();

    void age() {

    }

    public static void main(String[] args) {
        Button button = new Button();
        button.setOnClickListener(() -> {
            System.out.println("java onclick");
        });
    }
}

interface onClickListener {
    void onClick();
}

class Button {
    void setOnClickListener(onClickListener listener) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                listener.onClick();
            }
        }).start();
        System.out.println("java main finish");
    }
}