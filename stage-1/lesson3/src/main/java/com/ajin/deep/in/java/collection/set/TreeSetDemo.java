package com.ajin.deep.in.java.collection.set;

import java.util.Arrays;
import java.util.Set;
import java.util.TreeSet;

/**
 * {@link java.util.TreeSet} Demo
 *
 * @author ajin
 */

public class TreeSetDemo {

    public static void main(String[] args) {
        Set<String> set = new TreeSet<>(Arrays.asList("tom", "jack", "martin"));
        set.forEach(System.out::println);
    }
}
