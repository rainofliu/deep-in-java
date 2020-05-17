package com.ajin.deep.in.java.io;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * {@link java.io.FileInputStream} Demo
 *
 * @author ajin
 */

public class FileInputStreamDemo {

    public static void main(String[] args) throws IOException {
        InputStream inputStream = new FileInputStream("D:\\gitRepository\\organized-learning\\hello.txt");
        try {
            byte[] buf = new byte[1024];
            int bytesRead = inputStream.read(buf);
            String data = new String(buf, 0, bytesRead, "UTF-8");
            System.out.println(data);
        } finally {
            inputStream.close();
        }
    }
}
