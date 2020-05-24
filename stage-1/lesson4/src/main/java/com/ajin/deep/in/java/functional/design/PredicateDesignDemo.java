package com.ajin.deep.in.java.functional.design;

import java.util.*;
import java.util.function.Predicate;

/**
 * {@link Predicate} Desgin Demo
 *
 * @author ajin
 */

public class PredicateDesignDemo {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6);
        // 偶数
        Collection<Integer> even = filter(numbers, number ->
                number % 2 == 0
        );

        System.out.println(even);

        // 奇数
        Collection<Integer> odd = filter(numbers, number ->
                number % 2 != 0
        );

        System.out.println(odd);

    }

    private static <E> Collection<E> filter(Collection<E> source, Predicate<E> p) {
        // 集合类操作，不要直接利用参数
        // 拷贝一份，不会影响原有集合
        List<E> copy = new ArrayList<E>(source);
        Iterator<E> iterator = copy.iterator();
        while (iterator.hasNext()) {
            E element = iterator.next();
            if (!p.test(element)) {
                iterator.remove();
            }
        }
        return Collections.unmodifiableList(copy);
    }
}
