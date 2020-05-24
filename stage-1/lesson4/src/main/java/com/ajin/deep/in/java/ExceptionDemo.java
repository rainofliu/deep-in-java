package com.ajin.deep.in.java;

/**
 * @author ajin
 */

public class ExceptionDemo {
    public static void main(String[] args) {
        try {
            throw new NullPointerException();
        } catch (NullPointerException e) {
            for (StackTraceElement stackTraceElement : e.getStackTrace()) {
                System.out.println(stackTraceElement.getMethodName());
            }
        }
    }
}
