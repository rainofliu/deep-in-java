package com.ajin.deep.in.java.functional.stream;

import java.util.Comparator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * {@link Stream} Demo
 *
 * @author ajin
 */

public class StreamDemo {

    public static void main(String[] args) {
//        count(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        filter(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        map(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
//        sort(3, 1, 5, 10, 15, 8);
//        sort((x, y) -> (x > y) ? -1 : ((x.equals(y)) ? 0 : 1)
//                , 3, 1, 5, 10, 15, 8);

        parallelSort(3, 1, 5, 10, 15, 8,33,99,102,108,88);
    }

    /**
     * 计算多个数的总和
     */
    private static void count(Integer... numbers) {
        Stream.of(numbers)
                .reduce(Integer::sum) // 合并操作
                .ifPresent(System.out::println)
        ;
    }

    /**
     * 把所有奇数打出来
     */
    private static void filter(Integer... numbers) {
        Stream.of(numbers).filter((number) -> number % 2 != 0)
                .collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void map(Integer... numbers) {
        Stream.of(numbers).map(Integer::doubleValue).collect(Collectors.toList()).forEach(System.out::println);
    }

    private static void sort(Integer... numbers) {
        Stream.of(numbers).sorted().forEach(System.out::println);
    }

    private static void sort(Comparator<Integer> comparator, Integer... numbers) {
        Stream.of(numbers).sorted(comparator).forEach(System.out::println);
    }

    private static void parallelSort(Integer... numbers) {
        Stream.of(numbers).sorted().parallel().forEach(StreamDemo::println);
    }

    /**
     * [main] :8
     * [ForkJoinPool.commonPool-worker-4] :1
     * [ForkJoinPool.commonPool-worker-5] :5
     * [ForkJoinPool.commonPool-worker-3] :3
     * [ForkJoinPool.commonPool-worker-2] :15
     * [ForkJoinPool.commonPool-worker-1] :10
     */
    private static void println(Object object) {
        System.out.printf("[%s] :%s \n", Thread.currentThread().getName(), object);
    }
}
