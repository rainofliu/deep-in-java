package com.ajin.deep.in.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型测试Demo
 *
 * @author ajin
 */

public class GenericTestDemo {

//    private static final Map<String, Object> map = new HashMap<>();
//
//    public static void addAll(ArrayList<? extends E> c) {
//        for (int i = 0; i < c.size(); i++) {
//            add(c.get(i));
//        }
//    }
//
//    private static void add(E e) {
//        map.put(String.valueOf(e.hashCode()), e);
//    }

    public static void main(String[] args) {
//        List<Number> numbers = new ArrayList<>();
//        List<Integer> ints = new ArrayList<>();
//        ints.add(100);
//        ints.add(300);
//        // 编译器报错
////        ints.addAll(numbers);
//        numbers.addAll(ints);
//        Stream.of(numbers).forEach(System.out::println);
        List<Integer> ints = new ArrayList<>();
        List<? extends Number> numbers = ints;
        Integer a = 200;
//        numbers.add(a);
//        numbers.add((Number) a);
//        numbers.add((Object) a);
    }
}
