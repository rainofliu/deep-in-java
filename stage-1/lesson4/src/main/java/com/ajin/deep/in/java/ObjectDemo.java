package com.ajin.deep.in.java;

/**
 * @author ajin
 */

public class ObjectDemo {

    private static int anInt;

    public static void main(String[] args) {
        Interface interface1 = new ObjectDemo.Demo();
        if (interface1 instanceof Object) {
            System.out.println("test");
        }
        int x = 0;
        System.out.println(x);
        System.out.println(anInt);
    }

    static class Demo implements Interface {

    }
}
