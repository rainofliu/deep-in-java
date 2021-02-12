package com.ajin.deep.in.java.io.common;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 * I/O 的一些封装方法
 *
 * @author ajin
 * @see com.ajin.deep.in.java.io.charstream.FileDemoInCharSequence
 */

public class CommonIOUtils {

    public static final String TEST_SOURCE_FILE_PATH =
        "D:\\gitRepository\\organized-learning\\deep-in-java\\stage-8\\helloworld.txt";

    public static final String TEST_DESTINATION_FILE_PATH =
        "D:\\gitRepository\\organized-learning\\deep-in-java\\stage-8\\outputchar.txt";

    public static FileReader getFileReader() throws IOException {
        return new FileReader(TEST_SOURCE_FILE_PATH);
    }

    public static FileWriter getFileWriter() throws IOException {
        return new FileWriter(TEST_DESTINATION_FILE_PATH);
    }

}
