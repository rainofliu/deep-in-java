package com.ajin.deep.in.java.io;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.nio.charset.Charset;

/**
 * {@link java.io.OutputStream} Demo
 *
 * @author ajin
 */

public class OutputStreamDemo {

    public static void main(String[] args) throws IOException {
        OutputStream outputStream = new FileOutputStream("D:\\gitRepository\\organized-learning\\hello.txt");
        try {
            String data = "hello,World";
            byte[] bytes = data.getBytes(Charset.forName("UTF-8"));
            outputStream.write(bytes);
        } finally {
            outputStream.close();
        }
    }
}
