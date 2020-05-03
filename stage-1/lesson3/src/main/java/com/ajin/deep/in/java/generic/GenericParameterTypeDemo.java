package com.ajin.deep.in.java.generic;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.function.Consumer;

/**
 * @author ajin
 */

public class GenericParameterTypeDemo {
    public static void main(String[] args) {

        Container<String> a = new Container("String");
//        Container<Integer> b = new Container("String");
        Container<StringBuffer> bufferContainer = new Container("Hello,World!");
        // 通过构造器传递String类型，运行时都是Object类型(运行时擦写） ，没有问题
        System.out.println(bufferContainer.getElement()); // Hello,World!
        // 不过当bufferContainer对象申明的类型为 Container<StringBuffer> 时，类型为StringBuffer , 所以set(E)  E必须是StringBuffer
//        bufferContainer.set("1");
        bufferContainer.set(new StringBuffer("2020"));
        System.out.println(bufferContainer.getElement());// 2020

        add(new ArrayList<>(), "Hellow");
        add(new ArrayList<>(), 1); // aoto-boxing

        forEach(Arrays.asList(1,2,3,4,5), System.out::println);
    }

    public static class Container<E extends CharSequence> {
        private E element;

        public Container(E e) {
            this.element = e;
        }

        public boolean set(E e) {
            this.element = e;
            return true;
        }

        public E getElement() {
            return element;
        }

        public void setElement(E element) {
            this.element = element;
        }
    }

    // 多界限 泛型参数类型
    public static class C {

    }

    public static interface I1 {

    }

    public static interface I2 {

    }

    // 多界限绑定 extends 第一个类型可以是具体类(也可以是接口），第二个或更多参数类型是接口
//    public static class Template<T extends C & I & I2> {
//
//    }
    public static class Template<T extends C & I1 & I2> {

    }

    public static class TClass extends C implements I1, I2 {

    }

    /**
     * 把一个类型元素 添加到集合中
     *
     * @param target
     * @param element
     * @return void
     * @Description
     **/
//    public static <E> void add(Collection<E> target, E element) {
//        target.add(element);
//    }
    public static <C extends Collection<E>, E extends Serializable> void add(C target, E element) {
        target.add(element);
    }

    public static <C extends Iterable<E>, E extends Serializable> void forEach(C source, Consumer<E> consumer) {
        for (E e : source) {
            consumer.accept(e);
        }
    }
}
