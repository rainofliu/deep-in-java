package com.ajin.deep.in.java.collection.algorithm;

import java.util.stream.Stream;

import static com.ajin.deep.in.java.collection.algorithm.BubbleSort.of;

/**
 * 快速排序
 *
 * @author ajin
 */

public class QuickSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {
        // [3, 2, 1, 5, 4]
        // pivot = 4
        // [(3,2,1) ,(4) ,(5) ]
        int n = values.length;
        int low = 0;
        // 最后一个元素的下标
        int high = n - 1;

        // 获取pivot (轴）= values[high]
        // 获取分区的索引
        sort(values, low, high);
    }

    private void sort(T[] values, int low, int high) {

        if (low < high) {
            int pIndex = partition(values, low, high);
            sort(values, low, pIndex - 1);
            sort(values, pIndex + 1, high);
        }
    }

    /**
     * @param values 待排序的数组
     * @param low    低位索引
     * @param high   高位索引
     * @return int 分区索引
     **/
    int partition(T[] values, int low, int high) {

        // [3, 2, 1, 5, 4]
        // pivot = 4
        // [(3,2,1) ,(4) ,(5) ]

        // 3 2 1
        // pivot =1
        //

        // 4
        T pivot = values[high];
        // 0
        int i = low;

        // 遍历数组
        for (int j = low; j < high; j++) {
            // 如果当前元素比 pivot元素要小
            if (values[j].compareTo(pivot) < 1) {

                // 低位数据
                T temp = values[i];
                values[i] = values[j];
                values[j] = temp;

                i++;
            }
        }
        T temp = values[i];
        values[i] = values[high];
        values[high] = temp;

        return i;

    }

    public static void main(String[] args) {
        Sort<Integer> sort = new QuickSort<>();
        Integer[] values = of(2, 5, 6, 7, 8, 8, 9, 2, 1, 6, 7, 5, 6, 11, 23);
        sort.sort(values);
        Stream.of(values).forEach(System.out::println);
    }
}
