package com.ajin.deep.in.java.io.filesystem.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import static com.ajin.deep.in.java.io.filesystem.nio.PathDemo.USER_DIR_LOCATION;

/**
 * 文件操作 样例
 *
 * @author ajin
 */
public class FileOperationsDemo {

    public static void main(String[] args) throws IOException {
        fileExistValidation();
        fileAccessValidation();
        fileEqualValidation();
    }

    /**
     * 文件 存在性 校验
     */
    private static void fileExistValidation() {
        Path    path   = Paths.get(USER_DIR_LOCATION);
        boolean exists = Files.exists(path);
        System.out.printf("${user.dir} [%s] exist == ? %s \n", path, exists);
    }

    /**
     * 文件 访问性 校验
     */
    private static void fileAccessValidation() {
        Path path = Paths.get(USER_DIR_LOCATION);
        System.out.printf("${user.dir} [%s] isReadable=%s isWritable=%s   isExecutable=%s \n", path,
            Files.isReadable(path), Files.isWritable(path), Files.isExecutable(path));

    }

    /**
     * 文件 相等性 校验
     */
    private static void fileEqualValidation() throws IOException {
        Path path  = Paths.get(USER_DIR_LOCATION,"pom.xml");
        Path path2 = Paths.get(USER_DIR_LOCATION,"pom.xml");
        System.out.println(Files.isSameFile(path, path2));

    }
}
