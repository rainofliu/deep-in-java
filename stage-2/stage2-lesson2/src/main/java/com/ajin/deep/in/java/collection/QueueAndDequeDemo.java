package com.ajin.deep.in.java.collection;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * {@link Queue} && {@link Deque} Demo
 *
 * @author ajin
 */

public class QueueAndDequeDemo {

    public static void main(String[] args) {
        // LinkedList  add 和offer 方法没区别
        Queue<String> queue = new LinkedList<>();
        queue.add("a");
        queue.offer("b");
    }
}
