package com.oman.forward.pattern.structure.adapter;

public class Utils {

    public static int getOnLinePlayCount(int region) {
        switch (region) {
            case 2:
                return 6;
            case 3:
                return 3;
            default:
                break;
        }
        return -1;
    }
}
