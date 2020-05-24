package com.ajin.deep.in.java.functional.stream;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * @author ajin
 */

public class StreamCollectDemo {

    public static void main(String[] args) {
        List<Integer> values = Stream.of(1, 2, 3, 4, 5).collect(Collectors.toList());
        // class java.util.ArrayList
        System.out.println(values.getClass());
        values = Stream.of(1, 2, 3, 4, 5).collect(LinkedList::new, List::add, List::addAll);
        // class java.util.LinkedList
        System.out.println(values.getClass());
    }


}
