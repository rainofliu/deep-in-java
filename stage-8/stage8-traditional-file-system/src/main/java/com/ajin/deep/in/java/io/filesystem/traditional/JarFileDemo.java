package com.ajin.deep.in.java.io.filesystem.traditional;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.jar.JarFile;
import java.util.jar.Manifest;

/**
 * {@link JarFile}Demo
 * @author ajin
 */

public class JarFileDemo {

    public static void main(String[] args)throws IOException {
        Class<IOUtils> ioUtilsClass = IOUtils.class;
        // 获取类所在jar包的URL
        URL url = ioUtilsClass.getProtectionDomain().getCodeSource().getLocation();

        // JarFile 压缩文件对象
        try (JarFile jarFile = new JarFile(url.getPath())) {

            Manifest jarFileManifest = jarFile.getManifest();


            System.out.println(new HashMap<>(jarFileManifest.getMainAttributes()));

        }

    }
}
