package com.ajin.deep.in.java.io;

import java.io.File;

/**
 * {@link File} Demo
 *
 * @author ajin
 */

public class FileDemo {

    public static void main(String[] args) {
        // 实例化File对象
        File file = new File("c:/text.txt");
        // 检测文件是否存在
        boolean exists = file.exists();
        // 获取文件的长度
        long length = file.length();
    }
}
