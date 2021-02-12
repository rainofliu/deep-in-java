package com.ajin.deep.in.java.io.operations;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * @author ajin
 * @see ObjectOutputStream
 * @see ObjectInputStream
 * @see FileOutputStream
 */
public class ObjectStreamDemo {

    public static void main(String[] args) throws IOException, ClassNotFoundException {

        File outFile = new File("D:\\gitRepository\\organized-learning\\deep-in-java\\stage-8\\file.txt");

        // 对象序列化
        try (ObjectOutputStream outputStream = new ObjectOutputStream(new FileOutputStream(outFile))) {

            List<String> stringList = new ArrayList<>(Arrays.asList("1", "2", "3", "4", "5"));

            outputStream.writeObject(stringList);
            outputStream.flush();
        }

        // 对象反序列化
        try (ObjectInputStream inputStream = new ObjectInputStream(new FileInputStream(outFile))) {
            List<String> stringList = (List<String>)inputStream.readObject();
            System.out.println(stringList);
        }
    }
}
