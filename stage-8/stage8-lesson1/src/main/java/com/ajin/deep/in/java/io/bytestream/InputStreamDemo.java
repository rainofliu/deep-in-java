package com.ajin.deep.in.java.io.bytestream;

import java.io.*;

/**
 * {@link InputStream} Demo
 *
 * @author ajin
 * @see InputStream#read(byte[])
 * @see InputStream#read(byte[], int, int)
 */

public class InputStreamDemo {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[] {1, 2, 3, 4, 5};

        try (InputStream in = new BufferedInputStream(new ByteArrayInputStream(new byte[]{(byte)1002, (byte)2003,
            (byte)2004, (byte)2005}));
            OutputStream out = new FileOutputStream(
                "D:\\gitRepository\\organized-learning\\deep-in-java\\stage-8\\output.txt")) {
            int data = in.read(bytes);
            for (byte aByte : bytes) {
                System.out.println(aByte);
            }

           data = in.read(bytes,1,bytes.length-1);
            for (byte aByte : bytes) {
                System.out.println(aByte);
            }
        }
    }
}
