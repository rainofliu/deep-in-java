package com.ajin.deep.in.java.io.operations;

import java.io.DataOutputStream;
import java.io.IOException;

/**
 * @author ajin
 */
public class DataStreamDemo {

    public static void main(String[] args) throws IOException {
        DataOutputStream outputStream = new DataOutputStream(System.out);
        outputStream.writeByte(1);
        outputStream.writeChar(2);
        outputStream.writeUTF("3");
        outputStream.flush();
    }
}
