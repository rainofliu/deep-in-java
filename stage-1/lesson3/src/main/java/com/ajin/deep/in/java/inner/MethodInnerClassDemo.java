package com.ajin.deep.in.java.inner;

/**
 * 方法内部类Demo
 *
 * @author ajin
 */

public class MethodInnerClassDemo {
    private int a = 100;

    public void init(final int param) {
        final String str = "hello";
        class Inner {
            public void innerMethod() {
                System.out.println("innerMethod!");
            }
        }
        Inner inner = new Inner();
        inner.innerMethod();
    }

    public static void main(String[] args) {

    }
}
