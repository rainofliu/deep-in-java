package com.ajin.deep.in.java.collection.list;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ajin
 */

public class ListToArrayDemo {
    public static void main(String[] args) {
        List<Integer> list = new ArrayList<Integer>() {
            {
                add(1);
                add(2);
                add(3);
            }
        };
        Integer[] array0 = new Integer[2];
        list.toArray(array0);

        Integer[] array1 = new Integer[list.size()];
        list.toArray(array1);
    }
}
