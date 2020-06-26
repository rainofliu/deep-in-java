package com.ajin.deep.in.java.collection.algorithm;

/**
 * 排序接口
 * <p>
 * 原地排序：在排序过程中不产生额外的内存空间
 *
 * @author ajin
 */
public interface Sort<T extends Comparable<T>> {
    /**
     * 在Java中 数组一旦声明 容量就固定了（Java是静态语言）
     */
    void sort(T[] values);

    static <T> T[] of(T... values) {
        return values;
    }
}
