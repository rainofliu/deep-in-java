package com.ajin.deep.in.java.io;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;
import java.util.concurrent.CountDownLatch;

/**
 * @author ajin
 * @see PipedInputStream
 * @see PipedOutputStream
 */

public class PipeDemo {

    public static void main(String[] args) throws IOException, InterruptedException {
        CountDownLatch countDownLatch = new CountDownLatch(1);

        try (final PipedOutputStream outputStream = new PipedOutputStream();
            final PipedInputStream inputStream = new PipedInputStream(outputStream)) {

            Thread thread1 = new Thread(() -> {
                try {
                    outputStream.write("hello,word!pipes".getBytes());
                    countDownLatch.countDown();
                } catch (IOException e) {
                }

            });

            Thread thread2 = new Thread(() -> {
                try {
                    countDownLatch.await();
                    int data = inputStream.read();
                    while (data != -1) {
                        System.out.print(data);
                        data = inputStream.read();
                    }
                } catch (IOException | InterruptedException e) {
                    e.printStackTrace();
                }
            });

            thread1.start();
            thread2.start();
        }
    }
}
