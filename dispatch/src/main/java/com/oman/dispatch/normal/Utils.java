package com.oman.dispatch.normal;

public class Utils {
    public static String getAction(int action) {
        if (action == 0) {
            return " DOWN";
        } else if (action == 1) {
            return " UP";
        } else if (action == 2) {
            return " MOVE";
        } else if (action == 3) {
            return " CANCEL";
        }
        throw new IllegalArgumentException("wrong params");
    }
}
