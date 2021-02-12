package com.ajin.deep.in.java.io.file;

import java.io.File;

import static com.ajin.deep.in.java.io.common.CommonIOUtils.TEST_SOURCE_FILE_PATH;

/**
 * {@link File} 样例
 *
 * @author ajin
 * @see File
 */

public class FileDemo {

    public static void main(String[] args) {

        String  printInfoPrefix = "[" + TEST_SOURCE_FILE_PATH + "]路径对应的文件";
        File    file            = new File(TEST_SOURCE_FILE_PATH);
        boolean exists          = file.exists();
        String  existInfo       = exists ? "存在" : "不存在";
        // [D:\gitRepository\organized-learning\deep-in-java\stage-8\helloworld.txt]目录对应的文件存在
        System.out.println(printInfoPrefix + existInfo);

        System.out.println(printInfoPrefix + "长度为:[" + file.length() + "]字节");

        // true表示该路径存在并且是一个目录，
        // 如果返回false也有可能是路径不存在而不是指向文件。
        String pathInfo = file.isDirectory() ? "目录" : "文件";
        System.out.println("[" + TEST_SOURCE_FILE_PATH + "]路径 对应的是一个" + pathInfo);

        // 获取上一层路径
        File parentFile = file.getParentFile();
        // 读取路径直接对应的 文件或目录
        String[] childFileArr = parentFile.list();
        for (String childFile : childFileArr) {
            // 遍历 打印
            System.out.println(childFile);
        }

    }
}
