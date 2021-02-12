package com.ajin.deep.in.java.io.charstream;

import com.ajin.deep.in.java.io.common.CommonIOUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * @author ajin
 * @see BufferedReader
 * @see PrintWriter
 */
public class LineDemo {

    public static void main(String[] args) throws IOException {

        try (BufferedReader reader = new BufferedReader(CommonIOUtils.getFileReader());
            PrintWriter writer = new PrintWriter(CommonIOUtils.getFileWriter())) {

            String line;
            while ((line = reader.readLine()) != null) {
                writer.println(line);
            }
        }
    }
}
