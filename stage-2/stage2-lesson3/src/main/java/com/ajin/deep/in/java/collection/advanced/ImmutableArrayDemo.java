package com.ajin.deep.in.java.collection.advanced;

import java.util.Arrays;

/**
 * @author ajin
 * 1. 对于List<E> 返回值的方法，不要返回null ，应返回空集合 Collections.empty....
 * 2. 对于别人提供的方法，返回值一定要作空值判断
 */

public class ImmutableArrayDemo {

    public static void main(String[] args) {

//      Integer[] values = of(1, 2, 3);
        Integer[] values = of(1000, 2000, 3000);

        //1. 数组的拷贝和对象的clone一样，都是浅拷贝的
        Integer[] copy = Arrays.copyOf(values, values.length);

        for (int i = 0; i < values.length; i++) {
            System.out.println(values[i].equals(copy[i]));
        }


        // 修改复制后的内容
        copy[0] = 200;
        // 1000
        System.out.println(Arrays.toString(values));

        User[] users = of(1L, 2L, 3L);
        User[] usersCopy = Arrays.copyOf(users, users.length);
        User user1 = usersCopy[0];
        user1.setId(99L);
        // [User{id=99}, User{id=2}, User{id=3}]
        System.out.println(Arrays.toString(users));
        // 2. 如果需要只读数组，需要深度克隆
    }

    private static Integer[] of(Integer... values) {
        return values;
    }

    private static User[] of(Long... ids) {
        User[] users = new User[ids.length];

        for (int i = 0; i < ids.length; i++) {
            users[i] = new User(ids[i]);
        }

        return users;
    }

    private static class User {
        private Long id;

        private User(Long id) {
            this.id = id;
        }

        public Long getId() {
            return id;
        }

        void setId(Long id) {
            this.id = id;
        }

        @Override
        public String toString() {
            return "User{" +
                    "id=" + id +
                    '}';
        }
    }

    // 集合方法入参，如果能用Iterable 尽量用，如果不能用，则用Collection ,其次List/Set

    // 禁止使用具体类型 如LinkedHashSet ArrayList等等

}
