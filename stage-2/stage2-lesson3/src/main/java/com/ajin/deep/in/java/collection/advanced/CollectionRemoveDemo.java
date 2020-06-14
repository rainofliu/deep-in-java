package com.ajin.deep.in.java.collection.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * 集合的删除 最好用{@link java.util.Iterator}
 *
 * @author ajin
 */

public class CollectionRemoveDemo {

    public static List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3));

    public static void main(String[] args) {
        for (int i = 0; i < values.size(); i++) {
            values.remove(i);
        }
    }
}
