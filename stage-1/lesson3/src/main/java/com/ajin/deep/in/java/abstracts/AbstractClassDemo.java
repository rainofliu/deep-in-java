package com.ajin.deep.in.java.abstracts;

/**
 * @author ajin
 */

public abstract class AbstractClassDemo {

    public AbstractClassDemo() {
    }

    void test() {
        System.out.println("11");
    }

    public static void main(String[] args)throws Exception {
        Class<AbstractClassDemo> classDemoClass = AbstractClassDemo.class;
        AbstractClassDemo object = classDemoClass.newInstance();
        object.test();
    }
}
