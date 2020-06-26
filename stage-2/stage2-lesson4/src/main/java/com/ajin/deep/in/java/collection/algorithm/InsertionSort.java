package com.ajin.deep.in.java.collection.algorithm;

import java.util.Arrays;
import java.util.stream.Stream;

import static com.ajin.deep.in.java.collection.algorithm.BubbleSort.of;

/**
 * 插入排序
 *
 * @author ajin
 */

public class InsertionSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        int length = values.length;

//        for (int i = 1; i < length; i++) {
//// 高位数
//            T t = values[i];
//            for (int j = i - 1; j >= 0; j--) {
//
//
//                if (t.compareTo(values[j]) < 1) { // 高位< 低位
//
//
//                    values[i] = values[j]; // 高位获取低位的值
//
//                    values[j] = t; // 低位得到高位的值
//
//                }
//            }
//        }
        System.out.printf("排序前:%s\n", Arrays.toString(values));
        for (int i = 1; i < length; i++) {
            // 临时变量
            T t = values[i];
            int j = i;
            while (j > 0 && t.compareTo(values[j - 1]) < 0) {
                values[j] = values[j - 1];
                j--;
            }
            values[j] = t;

            System.out.printf("第%d轮:%s\n", i + 1, Arrays.toString(values));
        }
    }

    public static void main(String[] args) {
        Integer[] values = of(3, 2, 1, 5, 4);
        Sort<Integer> sort = new InsertionSort<>();
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
