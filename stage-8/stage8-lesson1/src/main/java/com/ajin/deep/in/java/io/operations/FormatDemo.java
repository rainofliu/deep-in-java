package com.ajin.deep.in.java.io.operations;

import java.util.Formatter;

/**
 * 格式化Demo
 *
 * @author ajin
 * @see java.util.Formatter#format(String, Object...)
 * @see String#format(String, Object...)
 * @see Appendable
 */

public class FormatDemo {

    public static void main(String[] args) {
        System.out.printf("hello, %s\n", "test");
        System.out.println(String.format("hello, %s", "test"));
        System.out.println(new Formatter().format("hello, %s", "test"));

    }
}
