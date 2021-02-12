package com.ajin.deep.in.java.io.bytestream;

import java.io.*;

/**
 * 基于字节流读写文件
 *
 * @author ajin
 * @see FileInputStream
 * @see FileOutputStream
 */
public class FileDemoInByte {

    public static void main(String[] args) throws IOException {

        try (InputStream in = new FileInputStream(
            "D:\\gitRepository\\organized-learning\\deep-in-java\\stage-8\\helloworld.txt");
            OutputStream out = new FileOutputStream(
                "D:\\gitRepository\\organized-learning\\deep-in-java\\stage-8\\output.txt")) {

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        }
    }
}
