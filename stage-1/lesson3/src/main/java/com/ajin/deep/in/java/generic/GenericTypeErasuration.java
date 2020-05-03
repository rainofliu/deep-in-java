package com.ajin.deep.in.java.generic;

import java.util.ArrayList;
import java.util.List;

/**
 * 泛型擦写Demo
 *
 * @author ajin
 */

public class GenericTypeErasuration {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        // String value =(String)list.get(0);
        String value = list.get(0);
    }

    public static class C implements Comparable<C>{

        @Override
        public int compareTo(C o) {
            return 0;
        }
    }
}
