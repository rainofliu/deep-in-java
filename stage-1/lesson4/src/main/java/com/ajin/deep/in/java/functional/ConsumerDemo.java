package com.ajin.deep.in.java.functional;

import java.util.function.Consumer;

/**
 * {@link Consumer} Demo
 *
 * @author ajin
 */

public class ConsumerDemo {

    public static void main(String[] args) {
        // 匿名内部类的写法
        Consumer consumer = new Consumer() {
            @Override
            public void accept(Object o) {
                System.out.println(o);
            }
        };

        // 函数式写法
        Consumer consumer1 = (o) -> {
            System.out.println(o);
        };
        consumer1.accept("hello,World");

        Consumer<String> consumer2 = ConsumerDemo::echo;
        consumer2.accept("Hello,ajin!");
        consumer2.andThen(consumer1);

    }

    private static void echo(String message) {
        System.out.println(message);
    }

}
