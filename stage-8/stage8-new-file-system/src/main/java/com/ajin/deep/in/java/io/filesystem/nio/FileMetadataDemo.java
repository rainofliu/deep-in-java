package com.ajin.deep.in.java.io.filesystem.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.LinkOption;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.attribute.DosFileAttributes;
import java.nio.file.attribute.PosixFileAttributes;
import java.nio.file.attribute.UserPrincipal;

import static com.ajin.deep.in.java.io.filesystem.nio.PathDemo.USER_DIR_LOCATION;
import static java.nio.file.LinkOption.NOFOLLOW_LINKS;

/**
 * 文件元数据 demo
 *
 * @author ajin
 * @see Files#getOwner(Path, LinkOption...)
 */

public class FileMetadataDemo {

    public static void main(String[] args) throws IOException {
        Path path = Paths.get(USER_DIR_LOCATION);

        // 获取⽂件 owner/权限（Posix File）
        UserPrincipal userPrincipal = Files.getOwner(path);
        // Path[D:\gitRepository\organized-learning\deep-in-java]'s owner is : DESKTOP-P0U1VAV\ajin (User)
        System.out.printf("Path[%s]'s owner is : %s\n", path, userPrincipal);
        // Path[D:\gitRepository\organized-learning\deep-in-java]'s lastModifiedTime is 2021-02-16T06:57:25.920416Z
        System.out.printf("Path[%s]'s lastModifiedTime is %s \n", path.toString(), Files.getLastModifiedTime(path));

        System.out.printf("Path[%s] size : %s   \n", path.toString(), Files.size(path));

        // 文件相关属性
        DosFileAttributes attrs = Files.readAttributes(path, DosFileAttributes.class);

        System.out.println(attrs.isArchive());
        System.out.println(attrs.isHidden());
        System.out.println(attrs.isReadOnly());
        System.out.println(attrs.isSystem());
    }
}
