package com.ajin.deep.in.java.collection;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * @author ajin
 */

public class DeepCloneDemo {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        ArrayList<String> values = new ArrayList<>();
        values.add("A");
        values.add("B");
        values.add("C");
        // 浅拷贝
        values.clone();

        // 深拷贝
        List<String> list = deepClone(values);

        for (int i = 0; i < values.size(); i++) {
            System.out.println(Objects.equals(values.get(i), list.get(i))); // true
            System.out.println(values.get(i) == list.get(i)); // false
        }

        List<String> deepCloneInJavaSerialization = deepCloneInJavaSerialization(values);

    }

    private static List<String> deepClone(List<String> source) {

        List<String> clone = new ArrayList<>(source.size());

        source.forEach(s -> {
            clone.add(new String(s));
        });

        return clone;
    }

    private static List<String> deepCloneInJavaSerialization(List<String> source) throws IOException, ClassNotFoundException {
        ArrayList<String> copy = new ArrayList<>(source);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);

        // 将copy对象序列化
        objectOutputStream.writeObject(copy);


        ByteArrayInputStream inputStream = new ByteArrayInputStream(outputStream.toByteArray());
//        StreamUtils.copy(inputStream, outputStream);
        ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

        List<String> clone = (List<String>) objectInputStream.readObject();


        return clone;

    }
}
