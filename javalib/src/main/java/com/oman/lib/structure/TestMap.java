package com.oman.lib.structure;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

public class TestMap {

    static final int hash(Object key) {
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public static void main(String[] args) {
        int hash = hash("12");
        int h = "12".hashCode();
        System.out.println(Integer.toBinaryString(h));
        System.out.println(Integer.toBinaryString(h>>>16));
        System.out.println(hash);
        HashMap<String, String> map = new HashMap<>(5);
        try {
            Field threshold = map.getClass().getDeclaredField("threshold");
            threshold.setAccessible(true);

            Field table = map.getClass().getDeclaredField("table");
            table.setAccessible(true);
            map.put("1", "1");
            map.put("2", "1");
            map.put("3", "1");
            System.out.println("size:" + map.size() + "--length:" + ((HashMap.Entry[]) table.get(map)).length + "--threshold:" + threshold.get(map));
            System.out.println("-------");
            map.put("4", "1");
            System.out.println("size:" + map.size() + "--length:" + ((HashMap.Entry[]) table.get(map)).length + "--threshold:" + threshold.get(map));
            map.put("5", "1");
            System.out.println("size:" + map.size() + "--length:" + ((HashMap.Entry[]) table.get(map)).length + "--threshold:" + threshold.get(map));
            map.put("6", "1");
            System.out.println("size:" + map.size() + "--length:" + ((HashMap.Entry[]) table.get(map)).length + "--threshold:" + threshold.get(map));
            map.put("7", "1");
            System.out.println("size:" + map.size() + "--length:" + ((HashMap.Entry[]) table.get(map)).length + "--threshold:" + threshold.get(map));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
