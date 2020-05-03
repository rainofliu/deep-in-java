package com.ajin.deep.in.java.inner;

/**
 * 成员内部类 Demo
 *
 * @author ajin
 */

public class MemberInnerClassDemo {

    private int shared = 100;

    protected class InnerClass {
        public void init() {
            System.out.println("init" + shared);
        }
    }

    public static void test() {
        MemberInnerClassDemo outer = new MemberInnerClassDemo();
        InnerClass innerClass = outer.new InnerClass();
        innerClass.init();
    }

    public static void main(String[] args) {
        test();
    }

}
