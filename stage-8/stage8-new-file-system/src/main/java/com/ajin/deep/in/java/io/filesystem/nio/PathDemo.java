package com.ajin.deep.in.java.io.filesystem.nio;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.file.FileSystem;
import java.nio.file.FileSystems;
import java.nio.file.Path;
import java.nio.file.Paths;

/**
 * {@link Path} Demo
 *
 * @author ajin
 */

public class PathDemo {

    public static final String USER_DIR_LOCATION = System.getProperty("user.dir");

    public static void main(String[] args) throws Exception {
        // displayPathInfo(USER_DIR_LOCATION);

        // absolute path : E:\mavenRepository\commons-io\commons-io\2.6\commons-io-2.6.jar
        // getFileName : commons-io-2.6.jar
        // getParent: E:\mavenRepository\commons-io\commons-io\2.6
        // uri= file:///E:/mavenRepository/commons-io/commons-io/2.6/commons-io-2.6.jar
        // URL ioUtilsLocation = IOUtils.class.getProtectionDomain().getCodeSource().getLocation();
        // Path path           = Paths.get(ioUtilsLocation.toURI());
        // displayPathInfo(path);

        // normalize();

        conversionPath();
    }

    /**
     * 根据绝对路径 展示 获取路径并 路径信息
     *
     * @param absolutePath 绝对路径
     */
    private static void displayPathInfo(String absolutePath) {

        // absolute path : D:\gitRepository\organized-learning\deep-in-java
        // getFileName : deep-in-java
        // getParent: D:\gitRepository\organized-learning

        Path path = Paths.get(absolutePath);
        displayPathInfo(path);
    }

    /**
     * 打印路径信息
     *
     * @param path 路径
     */
    private static void displayPathInfo(Path path) {
        System.out.println("-----------------------------------");
        // D:\gitRepository\organized-learning\deep-in-java
        System.out.printf("absolute path : %s \n", path.toString());

        FileSystem fileSystem = path.getFileSystem();

        Path fileName = path.getFileName();
        System.out.printf("getFileName : %s \n", fileName);

        System.out.printf("uri= %s\n", path.toUri());

        // System.out.printf("getName(0) %s \n",path.getName(0));
        // System.out.printf("getName(1) %s \n",path.getName(1));

        // getName(0) :  gitRepository
        // getName(1) :  organized-learning
        // getName(2) :  deep-in-java
        int nameCount = path.getNameCount();
        for (int i = 0; i < nameCount; i++) {
            System.out.printf("getName(%d) :  %s  \n", i, path.getName(i));
        }

        for (Path next : path) {
            System.out.printf("forEach path : %s \n", next);
        }

        Path pathParent = path.getParent();
        // getParent: D:\gitRepository\organized-learning
        System.out.printf("getParent: %s \n", pathParent);
        // getRoot: D:\
        System.out.printf("getRoot: %s \n", path.getRoot());// 磁盘

        // C:\
        // D:\
        // E:\
        // F:\
        // 将windows上的磁盘打印出来
        FileSystems.getDefault().getRootDirectories().forEach(System.out::println);
        System.out.println("-----------------------------------");

    }

    /**
     * 移除冗余路径
     */
    private static void normalize() {
        Path path = Paths.get("D:\\gitRepository\\organized-learning\\deep-in-java\\..\\");
        System.out.println(path.normalize());
    }

    /**
     * 转换路径
     */
    private static void conversionPath() throws URISyntaxException {

        // pathFromLocation : D:\gitRepository\organized-learning\deep-in-java
        // pathFromURI : D:\gitRepository\organized-learning\deep-in-java
        // pathFromFile : D:\gitRepository\organized-learning\deep-in-java
        // pathFromLocation == pathFromURI ? true
        // pathFromLocation == pathFromFile ? true

        // 通过路径 构建的Path
        Path pathFromLocation = Paths.get(USER_DIR_LOCATION);
        System.out.println("pathFromLocation : " + pathFromLocation);

        URI uri = new URI("file", "", ("/" + USER_DIR_LOCATION).replace(File.separatorChar, '/'), null);
        // 通过URI 构建的Path
        Path pathFromURI = Paths.get(uri);
        System.out.println("pathFromURI : " + pathFromURI);

        // 通过File 构建的Path
        File file         = new File(USER_DIR_LOCATION);
        Path pathFromFile = file.toPath();
        System.out.println("pathFromFile : " + pathFromFile);

        System.out.printf("pathFromLocation == pathFromURI ? %s\n", pathFromLocation.equals(pathFromURI));
        System.out.printf("pathFromLocation == pathFromFile ? %s\n", pathFromLocation.equals(pathFromFile));

    }

}
