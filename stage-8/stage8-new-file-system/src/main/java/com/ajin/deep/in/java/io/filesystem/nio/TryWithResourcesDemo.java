package com.ajin.deep.in.java.io.filesystem.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.ajin.deep.in.java.io.filesystem.nio.PathDemo.USER_DIR_LOCATION;

/**
 * Java 7 try-with-resources Demo
 *
 * @author ajin
 */

public class TryWithResourcesDemo {

    public static void main(String[] args) throws IOException {
        Path    pomXmlPath    = Paths.get(USER_DIR_LOCATION, "pom.xml");
        Charset charset = Charset.forName("UTF-8");

        readByPathBeforeJava7(pomXmlPath,charset);

        readByPathAfterJava7(pomXmlPath,charset);
    }

    private static void readByPathAfterJava7(Path path, Charset charset) {
        try (BufferedReader bufferedReader = Files.newBufferedReader(path, charset)) {
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                System.out.println(readLine);
            }
        }catch (IOException e){
            System.err.format("IOException : %s \n", e.getMessage());
        }
    }

    private static void readByPathBeforeJava7(Path path, Charset charset)throws IOException {
        BufferedReader bufferedReader = null;
        try {
            bufferedReader = Files.newBufferedReader(path, charset);
            for (String readLine = bufferedReader.readLine(); readLine != null; readLine = bufferedReader.readLine()) {
                //<?xml version="1.0" encoding="UTF-8"?>
                // <project xmlns="http://maven.apache.org/POM/4.0.0"
                //          xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
                //          xsi:schemaLocation="http://maven.apache.org/POM/4.0.0 http://maven.apache.org/xsd/maven-4.0.0.xsd">
                //     <modelVersion>4.0.0</modelVersion>
                //
                //     <groupId>com.ajin</groupId>
                //     <artifactId>deep-in-java</artifactId>
                //     <version>1.0-SNAPSHOT</version>
                //     <name>一入Java深似海系列</name>
                //     <modules>
                //         <module>stage-1</module>
                //         <module>stage-2</module>
                //         <module>stage-8</module>
                //     </modules>
                //     <packaging>pom</packaging>
                //
                // </project>
                System.out.println(readLine);
            }
        } catch (IOException e) {
            System.err.format("IOException : %s \n", e.getMessage());
        } finally {
            if (null != bufferedReader) {
                bufferedReader.close();
            }
        }
    }
}
