package com.oman.lib.structure;

import java.util.Comparator;
import java.util.EnumSet;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.Set;
import java.util.SortedSet;
import java.util.TreeSet;

public class TestSet {
    public static void main(String[] args) {
        System.out.println("-----HashSet------");
        Set<String> set = new HashSet<>();
        set.add("element 1");
        set.add("element 2");
        set.add("element 2");
        System.out.println(set.size());
        Iterator<String> iterator = set.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----linkedHashSet------");
        LinkedHashSet<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("ccc");
        linkedHashSet.add("aaa");
        linkedHashSet.add("ddd");
        Iterator<String> stringIterator = linkedHashSet.iterator();
        while (stringIterator.hasNext()) {
            System.out.println(stringIterator.next());
        }
        System.out.println("-----TreeSet------");
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("ccc");
        treeSet.add("aaa");
        treeSet.add("ddd");
        treeSet.add("bbb");
        System.out.println(treeSet.toString());
        System.out.println("------------------");
    }
}
