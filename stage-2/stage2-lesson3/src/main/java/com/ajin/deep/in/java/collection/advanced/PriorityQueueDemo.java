package com.ajin.deep.in.java.collection.advanced;

import java.util.Collections;
import java.util.PriorityQueue;

/**
 * {@link PriorityQueue} Demo
 *
 * @author ajin
 */

public class PriorityQueueDemo {

    public static void main(String[] args) {

        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>();

        priorityQueue.add(1);
        priorityQueue.add(2);
        priorityQueue.add(3);

        priorityQueue.forEach(System.out::println);
    }
}
