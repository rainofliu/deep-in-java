package com.ajin.deep.in.java.io.bytestream;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 字节数组Demo
 *
 * @author ajin
 */

public class ByteArrayDemo {

    public static void main(String[] args) throws IOException {
        byte[] bytes = new byte[] {1, 2, 3};
        try (InputStream inputStream = new ByteArrayInputStream(bytes)) {
            int data = inputStream.read();
            while (data != -1) {
                System.out.println(data);
                data = inputStream.read();
            }
        }

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        outputStream.write("woshinidage".getBytes());
        byte[] toByteArray = outputStream.toByteArray();
        for (byte value : toByteArray) {
            System.out.println(value);
        }


    }
}
