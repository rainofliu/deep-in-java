package com.ajin.deep.in.java.thread;

/**
 * @author ajin
 */

public class ThreadDemo1 {
    public static void main(String[] args) {
        Thread thread = new HelloThread();
        thread.start();

        Thread thread1=new Thread(() -> System.out.println("runnable"));
        thread1.start();
    }
}
