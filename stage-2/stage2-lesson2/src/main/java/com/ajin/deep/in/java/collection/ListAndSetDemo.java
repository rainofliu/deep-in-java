package com.ajin.deep.in.java.collection;

import java.util.HashSet;
import java.util.Set;

/**
 * @author ajin
 */

public class ListAndSetDemo {

    public static void main(String[] args) {

        // HashSet并不能保证顺序，但有些场景可能会误导你
        Set<String> values = new HashSet<>();

        // 字母场景
        values.add("a");
        values.add("b");
        values.add("c");
        //a
        //b
        //c
        // 感觉HashSet好像有序了呢
        values.forEach(System.out::println);


        // 数字场景
        // 1
        // 2
        // 3
        values.clear();
        values.add("1");
        values.add("2");
        values.add("3");
        values.forEach(System.out::println);

    }
}
