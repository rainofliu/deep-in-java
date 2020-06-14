package com.ajin.deep.in.java.collection.advanced;

import java.lang.ref.WeakReference;
import java.util.WeakHashMap;

/**
 * @author ajin
 * @see WeakHashMap
 * @see ThreadLocal.ThreadLocalMap
 */

public class WeakReferenceMapDemo {

    public static void main(String[] args) throws InterruptedException {
        demoWeakHashMap();
    }

    private static void demoWeakHashMap() throws InterruptedException {
        // 强引用
        // value变量是局部变量，存放在栈中
        // abc是常量
        String value = "abc";
        System.out.println(value.hashCode());

        // 弱引用
        User user = new User("ajin");
        WeakReference<User> weakReference = new WeakReference<>(user);
        // WeakReference继承Reference  ,Reference 入队
        // 获取引用对象
        for (int i = 0; i < 100; i++) {

            Thread.sleep(1*1000);

            System.out.println( weakReference.get());
        }

        WeakHashMap map = new WeakHashMap();
    }

    private static class User {
        private String name;

        public User() {
        }

        public User(String name) {
            this.name = name;
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        @Override
        public String toString() {
            return "User{" +
                    "name='" + name + '\'' +
                    '}';
        }
    }
}
