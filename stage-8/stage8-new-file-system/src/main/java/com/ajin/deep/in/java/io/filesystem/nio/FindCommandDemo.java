package com.ajin.deep.in.java.io.filesystem.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static com.ajin.deep.in.java.io.filesystem.nio.PathDemo.USER_DIR_LOCATION;

/**
 * 模拟 cmd <code>find</code> 指令 检索目录下的文件
 *
 * @author ajin
 */

public class FindCommandDemo {

    public static void main(String[] args) throws IOException {

        String      pattern     = "F[a-zA-Z]*.java";
        FindVisitor findVisitor = new FindVisitor(pattern);
        // Walks a file tree. 检索
        Files.walkFileTree(Paths.get(USER_DIR_LOCATION), findVisitor);
        System.out.printf("Found count : %s\n", findVisitor.getFoundCount());
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-1\lesson3\src\main\java\com\ajin\deep\in\java\io\FileDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-1\lesson3\src\main\java\com\ajin\deep\in\java\io\FileInputStreamDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-1\lesson4\src\main\java\com\ajin\deep\in\java\functional\design\FunctionDesignDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-1\lesson4\src\main\java\com\ajin\deep\in\java\functional\FunctionalInterfaceDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-1\lesson4\src\main\java\com\ajin\deep\in\java\functional\FunctionDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-lesson1\src\main\java\com\ajin\deep\in\java\io\bytestream\FileDemoInByte.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-lesson1\src\main\java\com\ajin\deep\in\java\io\bytestream\FileInputStreamDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-lesson1\src\main\java\com\ajin\deep\in\java\io\charstream\FileDemoInCharSequence.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-lesson1\src\main\java\com\ajin\deep\in\java\io\file\FileDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-lesson1\src\main\java\com\ajin\deep\in\java\io\operations\FormatDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-new-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\nio\FileOperationsDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-new-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\nio\FileOperationsUsingByteChannelDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-new-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\nio\FindCommandDemo.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-new-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\nio\FindVisitor.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-traditional-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\traditional\filechange\FileChangedEvent.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-traditional-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\traditional\filechange\FileChangedEventPublisher.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-traditional-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\traditional\filechange\FileChangedListener.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-traditional-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\traditional\filechange\FileMonitor.java
        // Found file : D:\gitRepository\organized-learning\deep-in-java\stage-8\stage8-traditional-file-system\src\main\java\com\ajin\deep\in\java\io\filesystem\traditional\FileDescriptorDemo.java
        // Found count : 19
    }
}
