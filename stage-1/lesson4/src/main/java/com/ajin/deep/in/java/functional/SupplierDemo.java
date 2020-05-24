package com.ajin.deep.in.java.functional;

import java.util.function.Supplier;

/**
 * @author ajin
 */

public class SupplierDemo {

    public static void main(String[] args) {
        Supplier<Long> supplier = getLong();
        supplier.get();
    }


    public static Supplier<Long> getLong() {
        return () -> System.currentTimeMillis();
    }

    /**
     * 非函数式写法
     */
    public static Supplier<Long> getLongNormal() {
        Supplier<Long> supplier = new Supplier<Long>() {
            @Override
            public Long get() {
                return System.currentTimeMillis();
            }
        };
        return supplier;
    }
}
