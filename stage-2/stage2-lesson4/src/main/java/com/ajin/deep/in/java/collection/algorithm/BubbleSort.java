package com.ajin.deep.in.java.collection.algorithm;

import java.util.Arrays;

/**
 * 冒泡排序  依次交换，大的元素往后面放
 *
 * @author ajin
 */

public class BubbleSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        // Comparable  compareTo
        // <  -1
        // = 0
        // > 1

        // 数组长度
        int size = values.length;
        //       [3,2,1,5,4]


        for (int i = 0; i < size; i++) {
            // 第i号元素 临时变量
            boolean noSwapFlag = true; // 没有发生交换
            for (int j = 0; j < size - i - 1; j++) {
                // 第i号元素与第i+1 号元素 比较
                // 交换元素 [i+1] =[i]
                T t = values[j];
                if (t.compareTo(values[j + 1]) == 1) {
                    values[j] = values[j + 1];
                    values[j + 1] = t;

                    noSwapFlag = false; // 发生了元素交换
                }
            }
            // 上一次循环没有元素发生交换 顺序已经调整好了 不用再排序了
            if (noSwapFlag) {
                break;
            }
            System.out.printf("第%d轮:%s\n", i + 1, Arrays.toString(values));
        }
    }

    public static void main(String[] args) {
        Integer[] values = of(3, 2, 1, 5, 4);
        BubbleSort<Integer> bubbleSort = new BubbleSort<>();
        bubbleSort.sort(values);
//        Stream.of(values).forEach(System.out::println);
    }

    public static <T> T[] of(T... values) {
        return values;
    }
}
