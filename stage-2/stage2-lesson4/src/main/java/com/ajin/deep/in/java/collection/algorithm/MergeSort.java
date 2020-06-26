package com.ajin.deep.in.java.collection.algorithm;

/**
 * 合并排序
 *
 * @author ajin
 */

public class MergeSort<T extends Comparable<T>> implements Sort<T> {

    @Override
    public void sort(T[] values) {

    }

    private void sort(T[] values, int low, int high) {

        if (low < high) {

            // 获取中值
            int mid = (low + high) >> 1;
            sort(values, low, mid);
            sort(values, mid + 1, high);
        }
    }

    private void merge(Comparable<T>[] values, int low, int mid, int high) {
        int n1 = mid - low + 1;
        int n2 = high - mid;

        Comparable<T>[] a1 = new Comparable[n1];

        Comparable<T>[] a2 = new Comparable[n2];

        // 赋值
        System.arraycopy(values, mid, a1, 0, n1);
        System.arraycopy(values, mid + 1, a2, 0, n2);


        // 合并
        int k = low; // k 临时保存低位索引
        int i = 0, j = 0;
        for (; i < n1 && j < n2; k++){
            // 如果 a1 与 a2 比较
            if (a1[i].compareTo(a2[j]) < 1) {  // <=
                values[k] = a1[i]; // 低位数值
                i++;
            } else { // >
                values[k] = a2[j];
                j++;
            }
        }
    }
}
