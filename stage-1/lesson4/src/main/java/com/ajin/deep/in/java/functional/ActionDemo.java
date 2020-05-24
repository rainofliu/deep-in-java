package com.ajin.deep.in.java.functional;

/**
 * @author ajin
 */

public class ActionDemo {
    public static void main(String[] args) {
        // 匿名内置类 invokeSpecial
        Runnable runnable = new Runnable() {
            @Override
            public void run() {
                System.out.println("hello");
            }
        };
        // @since jdk 1.7 invokeDynamic
        // java.lang.invoke.MethodHandle  &&  java.lang.invoke.InvokeDynamic
        Runnable runnable2 = () -> {

        };
    }
}
