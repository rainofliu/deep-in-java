package com.ajin.deep.in.java.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * 泛型通配类型参数
 *
 * @author ajin
 */
public class GenericWildcardsTypeDemo {

    public static void main(String[] args) {
        List<Number> numbers = new ArrayList<>();

        upperBoundedWildcards(numbers);

        unboundedWildcards(numbers);

        lowerBoundedWildcards(numbers);
    }

    /**
     * 上界 通配符
     *
     * @param numbers
     */
    private static void upperBoundedWildcards(List<Number> numbers) {
        numbers.add(Byte.valueOf((byte) 1));
        numbers.add(Short.valueOf((short) 2));
        numbers.add(Integer.valueOf(3));
        numbers.add(Long.valueOf(4L));

        List<Byte> bytes = Arrays.asList((byte) 5);
        List<Short> shorts = Arrays.asList((short) 6);
        List<Integer> integers = Arrays.asList(7);
        // List.boolean addAll(Collection<? extends E> c);
        numbers.addAll(bytes); // ? extends Number; List<Byte>
        numbers.addAll(shorts);// ? extends Number; List<Short>
        numbers.addAll(integers);// ? extends Number; List<Integer>

        upperBoundedWildcardsDemo(numbers, System.out::println);
        // 被操作（处理）的对象，需要更为抽象类型，Number
        // 待整合（输入）的对象，可以是具体类型
    }

    /**
     * 下界通配符
     *
     * @param numbers
     */
    private static void lowerBoundedWildcards(List<Number> numbers) {

        lowerBoundedWildcardsDemo(numbers, numbers);
    }

    // PECS stands for producer-extends, consumer-super.
    private static void lowerBoundedWildcardsDemo(List<? extends Number> producer, List<? super Number> consumer) {
        // 读取数据（生产者）使用 extends
        for (Number number : producer) {

        }
        // 操作输出（消费者）使用 super
        consumer.add(1);
        consumer.add((short) 2);
    }


    private static void unboundedWildcards(List<Number> numbers) {
        // 完全通配类型
        // 在运行时与非通配泛型会出现方法签名冲突
        // 然后完全通配类型，可以适配任意类型，比如集合
        // 反而具体类型泛型会限制类型范围
        unboundedWildcardsDemo(numbers);
    }

    /**
     * 无界通配符
     *
     * @param iterable
     */
    public static void unboundedWildcardsDemo(Iterable<?> iterable) { // 泛型类型擦写，导致和下方法冲突
        for (Object e : iterable) {
            System.out.println(e);
        }

    }

//
//    public static void unboundedWildcardsDemo(Iterable<Object> iterable) {
//        for (Object e : iterable) {
//            System.out.println(e);
//        }
//    }

    private static void upperBoundedWildcardsDemo(List<? extends Number> list, Consumer<Object> consumer) {
        for (Object element : list) {
            consumer.accept(element);
        }
    }
}
