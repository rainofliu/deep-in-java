package com.ajin.deep.in.java.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

/**
 * @author ajin
 */

public class PipeExample {
    /**
     * 当使用两个相关联的管道流时，务必将它们分配给不同的线程。
     * read()方法和write()方法调用时会导致流阻塞，这意味着如果你尝试在一个线程中同时进行读和写，可能会导致线程死锁。
     */
    public static void main(String[] args) throws Exception {
        // 管道输出流
        final PipedOutputStream output = new PipedOutputStream();
        // 管道输入流
        final PipedInputStream input = new PipedInputStream(output);

        Thread thread1 = new Thread(() -> {
            try {
                output.write("hello,world,pipeline".getBytes());
            } catch (IOException e) {
            } finally {
                try {
                    output.close();
                } catch (IOException e) {

                }
            }
        });

        Thread thread2 = new Thread(() -> {
            try {
                int data = input.read();
                // 通过循环不停读取 管道输入流中的字节
                while (data != -1) {
                    System.out.println((char) data);
                    data = input.read();
                }
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    input.close();
                } catch (IOException e) {

                }
            }
        });


        thread1.start();

        thread2.start();

    }
}
