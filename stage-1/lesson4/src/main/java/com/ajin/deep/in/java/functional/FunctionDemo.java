package com.ajin.deep.in.java.functional;

import java.util.function.Function;

/**
 * @author ajin
 */

public class FunctionDemo {
//   private static final Function<String, Long> function = Long::valueOf;

    public static void main(String[] args) {
        Function<String, Long> stringLongFunction = Long::valueOf;
        Long aLong = stringLongFunction.apply("123");
        System.out.println(aLong);

        Function<Long, String> longStringFunction = String::valueOf;
        String apply = longStringFunction.apply(123L);
        System.out.println(apply);

        //
        Long value = stringLongFunction.compose(String::valueOf).apply("10086");

    }
}
