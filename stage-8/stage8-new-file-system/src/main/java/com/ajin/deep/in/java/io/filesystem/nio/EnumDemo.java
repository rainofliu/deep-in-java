package com.ajin.deep.in.java.io.filesystem.nio;

import java.nio.file.attribute.PosixFilePermission;

/**
 * @author ajin
 */

public class EnumDemo {
    public static void main(String[] args) {
        for (PosixFilePermission value : PosixFilePermission.values()) {
            System.out.println(value.name()+value.ordinal());
        }
    }
}
