package com.ajin.deep.in.java.functional;

/**
 * {@link FunctionalInterface} Demo
 *
 * @author ajin
 */

public class FunctionalInterfaceDemo {

    public static void main(String[] args) {

        Function1 function1 = () -> {

        };
    }

    @FunctionalInterface
    interface Function1 {
        void execute();

        //void execute1();
        default String getDescription() {
            return String.valueOf(this);
        }
    }
}
