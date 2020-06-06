package com.ajin.deep.in.java.collection;

import java.util.*;

/**
 * @author ajin
 */

public class MapAndSetDemo {

    public static void main(String[] args) {

        // 通常 Set 是Map Key的实现 ，Set的底层运用Map实现
        // HashSet 底层用HashMap来实现
        Map<String, Object> map = new HashMap<>();

        Set<String> set = new HashSet<>();

        // TreeSet <-   TreeMap
        // LinkedHashSet  <-  LinkedHashMap
        map = new TreeMap<>();
        set = new TreeSet<>();
    }
}
