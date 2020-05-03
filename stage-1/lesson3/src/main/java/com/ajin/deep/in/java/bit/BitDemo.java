package com.ajin.deep.in.java.bit;


/**
 * @author ajin
 */

public class BitDemo {
    public static void main(String[] args) {
        System.out.println(tableSizeFor(19));

    }

    static int tableSizeFor(int cap) {
        // cap=16
        int n = cap - 1; // 15
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 1 : n + 1;
    }
}
