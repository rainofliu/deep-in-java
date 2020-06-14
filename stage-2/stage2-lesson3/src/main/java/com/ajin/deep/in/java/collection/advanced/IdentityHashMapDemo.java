package com.ajin.deep.in.java.collection.advanced;

import java.util.HashMap;
import java.util.IdentityHashMap;
import java.util.Map;
import java.util.Objects;

/**
 * {@link IdentityHashMap}Demo
 *
 * @author ajin
 */

public class IdentityHashMapDemo {

    public static void main(String[] args) {
        demoHashMap();
        demoIdentityHashMap();

    }

    private static void demoHashMap() {
        Map<String, Integer> map = new HashMap<>(16);
        map.put("A", 1);
        map.put(new String("A"), 1);

        // 1
        System.out.println(map.size());
        System.out.println("A".equals(new String("A")));
        System.out.println("A".hashCode() == (new String("A").hashCode()));
    }

    private static void demoIdentityHashMap() {
        Map<String, Integer> map = new IdentityHashMap<>(16);
        map.put("A", 1);
        map.put(new String("A"), 1);

        // 1
        System.out.println(map.size());
        System.out.println("A".equals(new String("A")));
        System.out.println("A".hashCode() == (new String("A").hashCode()));
    }

    // 在覆盖equals方法的情况下，建议覆盖hashCode方法 ，hashCode 是一个较重的实现
    // 在覆盖hashCode方法的前提下，必须覆盖equals方法，因为hashCode会产生冲突 ;hash冲突时，只能用equals方法来比较两个对象
    // hashCode冲突的原因：1. int值的范围是有限的；2. hashCode方法的问题

    private String name;

    private int age;

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        IdentityHashMapDemo that = (IdentityHashMapDemo) o;
        return age == that.age &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
