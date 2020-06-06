package com.ajin.deep.in.java.collection;

import java.util.Map;

/**
 * @author ajin
 */

public class MapDemo {

    public static void main(String[] args) {
        Map<Integer, String> map = Map.of(1, "A");
        System.out.println(map.get(1));
    }
}
