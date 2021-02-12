package com.ajin.deep.in.java.io.operations;

import java.io.IOException;

/**
 * @author ajin
 */

public class CommandLineDemo {

    public static void main(String[] args) throws IOException {
        System.out.println("按任意键退出......");
        // 阻塞线程
        System.in.read();
    }
}
