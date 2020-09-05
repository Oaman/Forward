package com.oman.lib.structure;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;

public class TestHashMapSafe {
    public static void main(String[] args) {
        final Map<Integer, String> map = new HashMap<>(16);

        final Integer targetKey = 0b1111_1111_1111_1111; // 65 535
        final String targetValue = "v";
        map.put(targetKey, targetValue);

        new Thread(() -> {
            IntStream.range(0, targetKey).forEach(key -> map.put(key, "someValue"));
        }).start();

        while (true) {
            if (null == map.get(1)) {
                throw new RuntimeException("HashMap is not thread safe.");
            }
        }

//        HashMap<Integer,String> map = new HashMap<>(16);
//        String s = map.get(1);
//        System.out.println(s);
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                IntStream.range(0,65535).forEach(key->{
//                    map.put(key,"1");
//                });
//            }
//        }).start();
//
//        while (true){
//            if (null==map.get(65535)){
//                System.out.println("exception");
//            }
//        }

    }
}
