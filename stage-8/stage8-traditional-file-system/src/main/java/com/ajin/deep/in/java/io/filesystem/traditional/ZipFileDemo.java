package com.ajin.deep.in.java.io.filesystem.traditional;

import org.apache.commons.io.IOUtils;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.nio.charset.Charset;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

/**
 * @author ajin
 */

public class ZipFileDemo {

    public static void main(String[] args) throws IOException {
        Class<IOUtils> ioUtilsClass = IOUtils.class;
        // 获取类所在jar包的URL
        URL url = ioUtilsClass.getProtectionDomain().getCodeSource().getLocation();

        // 获取ZipFile 压缩文件对象
        try (ZipFile zipFile = new ZipFile(url.getPath(), Charset.defaultCharset())) {
            // Collections.list(zipFile.entries()).forEach(System.out::println);

            // 获取ZipEntry
            ZipEntry manifestEntry = zipFile.getEntry("META-INF/MANIFEST.MF");

            try (InputStream inputStream = zipFile.getInputStream(manifestEntry)) {
                String manifestDetailInfo = IOUtils.toString(inputStream, "UTF-8");
                System.out.println(manifestDetailInfo);
            }

        }

    }
}
