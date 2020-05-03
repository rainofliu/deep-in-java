package com.ajin.deep.in.java.generic;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author ajin
 */

public class ClassCastDemo {

    public static void main(String[] args) {
        List list = new ArrayList();
        list.add("a");
        list.add(1);

        List<Object> list1 = list;
        List<String> stringList = Collections.emptyList();
        // 运行时不报错，编译会报错
//        stringList = list1;

        Type type = int.class;
        Class intType = int.class;
    }

    /**
     * @param a String List
     * @param b Integer List
     * @return void
     * @Description
     **/
    private static void exchange(List a, List b) {
        a.addAll(b);
        Integer value = (Integer) a.get(0);

    }

    /**
     * 枚举也可以作为泛型
     */
    public static class Application<GenericEnum> {

    }
}
