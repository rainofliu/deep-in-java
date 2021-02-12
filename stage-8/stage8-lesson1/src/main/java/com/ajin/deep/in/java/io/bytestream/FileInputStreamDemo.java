package com.ajin.deep.in.java.io.bytestream;

import java.io.*;

/**
 * {@link FileInputStream}Demo
 *
 * @author ajin
 * @see FileInputStream
 */
public class FileInputStreamDemo {

    private static String illegalFilePath = "d:\\test.doc";

    public static void main(String[] args) throws IOException {
        File        file        = new File(illegalFilePath);
        file.createNewFile();
        InputStream inputStream=null;
        try {
         inputStream = new FileInputStream(file);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }finally {
            if (null!=inputStream){
                try {
                    inputStream.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
