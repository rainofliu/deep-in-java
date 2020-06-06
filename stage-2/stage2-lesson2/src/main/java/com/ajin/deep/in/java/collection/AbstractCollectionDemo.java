package com.ajin.deep.in.java.collection;

import java.util.AbstractList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ajin
 */

public class AbstractCollectionDemo {

    public static void main(String[] args) {
        List<Integer> values = Arrays.asList(1, 2, 3);
        assert values instanceof AbstractList;

        values.set(2,6);
        values.forEach(System.out::println);
    }
}
