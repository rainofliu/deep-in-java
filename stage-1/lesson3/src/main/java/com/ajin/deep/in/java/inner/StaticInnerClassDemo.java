package com.ajin.deep.in.java.inner;

/**
 * 静态内部类 Demo
 *
 * @author ajin
 */

public class StaticInnerClassDemo {

    private static int shared = 100;

    protected static class InnerClass {
        public void init() {
            System.out.println("init" + shared);
        }
    }

    public static void test() {
        InnerClass innerClass = new InnerClass();
        innerClass.init();
    }

    public static void main(String[] args) {
        test();
    }

}
