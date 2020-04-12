package com.ajin.deep.in.java;

import java.lang.reflect.Field;

/**
 * @author ajin
 */

public class StringDemo {

    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        // 常量（语法特性）== 对象类型常量化
        // 常量化是原生类型支持， 赋值方式
        int a = 3;
        String value = "hello";
        // 面向对象规则：一切对象要new

        // 合法的写法（但会被视作异类）
        String value2 = new String("hello");

        System.out.println("value :"+value);
        System.out.println("value2 :"+value2);

        // 从Java1.5开始，对象的属性可以通过反射来修改
        char[] chars = "World".toCharArray();
        // 获取String当中的value字段
        Field valueField =String.class.getDeclaredField("value");
        // 设置value字段可以被修改
        valueField.setAccessible(true);
        // 修改value值
       valueField.set(value2,chars);

        System.out.println("value :"+value);
        System.out.println("value2 :"+value2);
    }

    public static class ExtendableString {
        private final char value[];

        private int hash;

        public ExtendableString(String value) {
            this.value = value.toCharArray();
        }

        @Override
        public final int hashCode() {
            int h = hash;
            if (h == 0 && value.length > 0) {
                char val[] = value;

                for (int i = 0; i < value.length; i++) {
                    h = 31 * h + val[i];
                }
                hash = h;
            }
            return h;
        }

        @Override
        public final boolean equals(Object anObject) {
            return true;
        }

    }
}
