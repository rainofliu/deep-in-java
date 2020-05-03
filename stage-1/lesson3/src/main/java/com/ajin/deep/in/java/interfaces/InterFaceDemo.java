package com.ajin.deep.in.java.interfaces;

/**
 * Java 8/9的接口Demo
 *
 * @author ajin
 */
public interface InterFaceDemo {


    void method1();

    static void method2() {
        System.out.println("haha");
    }
    default void method3(){
        System.out.println("method3");
    }
}
