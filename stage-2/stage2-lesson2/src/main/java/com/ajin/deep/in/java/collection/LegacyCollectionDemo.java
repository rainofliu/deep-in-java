package com.ajin.deep.in.java.collection;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

/**
 * @author ajin
 */

public class LegacyCollectionDemo {

    public static void main(String[] args) {
        // Vector <- AbstractList 数组  线程安全 synchronized
        Vector<String> vector = new Vector<>();
        List<String> list = new ArrayList<>();

        Map<String, Object> map = new HashMap<>(16);
        // its ok
        map.put(null, null);
        map = new ConcurrentHashMap<>(16);

        // ConcurrentHashMap key value all not null
        // 如果value允许为空的话，ConcurrentHashMap在查询数据时，会产生歧义
        // 到底是值为null 还是 线程不可见
        // java.lang.NullPointerException
//        map.put(null, null);

        String value = "1,2,3";
        value.split(",");

        // Enumeration
        StringTokenizer stringTokenizer = new StringTokenizer(value, ",");
        // like Iterator.hasNext()
        while (stringTokenizer.hasMoreElements()) {
            // iterator.next()
            Object o = stringTokenizer.nextElement();
            System.out.println(o);
        }

        // Iterable 从Java5 引入，用于for-each 语法提升
    }
}
