package com.ajin.deep.in.java.packaged;

/**
 * {@link Integer} Demo
 *
 * @author ajin
 */

public class IntegerDemo {
    public static void main(String[] args) {
        int a = 0x12345678;
        System.out.println(Integer.toBinaryString(a));
        int r = Integer.reverse(a);
        System.out.println(Integer.toBinaryString(r));
        int rb = Integer.reverseBytes(a);
        System.out.println(Integer.toHexString(rb));
    }
}
