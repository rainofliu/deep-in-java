package com.ajin.deep.in.java.functional.design;

import java.util.function.Function;

/**
 * {@link Function} Design Demo
 *
 * @author ajin
 */

public class FunctionDesignDemo {

    public static void main(String[] args) {
        // 入什么 出什么 像废话一样
        Function function = (a) -> a;
        // 想同类型也可以转换
        Function<Integer, Integer> divide2 = a -> a / 2;
    }
}
