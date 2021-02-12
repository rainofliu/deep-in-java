package com.ajin.deep.in.java.io.charstream;

import com.ajin.deep.in.java.io.common.CommonIOUtils;

import java.io.*;

/**
 * 基于字符流的方式 读写文件
 *
 * @author ajin
 * @see FileReader
 * @see FileWriter
 */

public class FileDemoInCharSequence {

    public static void main(String[] args) throws IOException {
        try (Reader in = CommonIOUtils.getFileReader() ;
            Writer out = CommonIOUtils.getFileWriter()) {

            int data;
            while ((data = in.read()) != -1) {
                out.write(data);
            }
        }
    }
}
