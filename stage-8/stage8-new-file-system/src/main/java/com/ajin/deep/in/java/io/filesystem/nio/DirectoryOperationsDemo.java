package com.ajin.deep.in.java.io.filesystem.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.stream.Stream;

/**
 * 目录操作 demo
 *
 * @author ajin
 */
public class DirectoryOperationsDemo {

    /**
     * 创建目录
     */
    public static void main(String[] args) {

        String classPath = System.getProperty("java.class.path");

        Stream.of(classPath.split(File.pathSeparator))

            .map(Paths::get) // String -> Path
            .filter(Files::isDirectory) // 过滤目录
            .filter(Files::isReadable).filter(Files::isWritable).map(Path::toString) // Path -> String
            .map(pathDir -> Paths.get(pathDir, "parent-dir", "sub-dir")) // String -> new Path
            .forEach(newDir -> {
                try {
                    // 创建目录
                    Path directories = Files.createDirectories(newDir);
                    System.out.printf("成功创建新的目录: %s \n", directories);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
        // System.out.println(classPath);
    }
}
