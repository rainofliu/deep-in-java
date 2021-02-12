package com.ajin.deep.in.java.io.charstream;

import java.io.CharArrayReader;
import java.io.CharArrayWriter;
import java.io.IOException;
import java.io.Reader;

/**
 * 字符数组Demo
 *
 * @author ajin
 */

public class CharArrayDemo {

    public static void main(String[] args) throws IOException {
        char[] chars = new char[] {'a', 'b', 'c', 'd', 'e'};
        try (Reader charArrayReader = new CharArrayReader(chars)) {
            int data = charArrayReader.read();
            while (data != -1) {
                System.out.println((char)data);
                data = charArrayReader.read();
            }
        }

        try (CharArrayWriter writer = new CharArrayWriter()) {
            writer.write(chars);
            char[] toCharArray = writer.toCharArray();
            for (char value : toCharArray) {
                System.out.println(value);
            }
        }

    }
}
