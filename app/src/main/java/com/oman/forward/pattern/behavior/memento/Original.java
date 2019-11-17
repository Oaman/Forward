package com.oman.forward.pattern.behavior.memento;

public class Original {
    private String value;

    public Original(String value) {
        this.value = value;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public Memento createMemo() {
        return new Memento(value);
    }

    public void restoreMemo(Memento memo){
        this.value = memo.getValue();
    }

}
