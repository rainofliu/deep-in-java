package com.ajin.deep.in.java.collection.advanced;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * @author ajin
 */
@SuppressWarnings("all")
public class CheckedTypeCollectionDemo {

    public static void main(String[] args) {

//        List<Integer> values = Arrays.asList(1, 2, 3);
        List<Integer> values = new ArrayList<>(Arrays.asList(1, 2, 3));
//        values.add("1");// 编译错误

        // 泛型 是 编译时检查 运行时擦写
        // 运行时数据 List<Integer>  -> List<Object>  -> List
        // values.add("1”）  运行时允许，因为成员类型是Object

        // 引用 List<Integer> 类型的对象alues
        // 骗过编译时检查
        List referencedValues = values;
        System.out.println(referencedValues == values);// true

        // 成功添加
        referencedValues.add("A"); // 添加A 进入List<Integer>中

        referencedValues.add(6);

        // Exception in thread "main" java.lang.ClassCastException: java.lang.String cannot be cast to java.lang.Integer
        //	at java.util.ArrayList.forEach(ArrayList.java:1257)
        //	at com.ajin.deep.in.java.collection.advanced.CheckedTypeCollectionDemo.main(CheckedTypeCollectionDemo.java:29)
//        values.forEach(System.out::println);

        // 运行成功，没有报错
        for (Object value : values) {
            System.out.println(value);
        }

        List<Integer> checkedTypeValues = Collections.checkedList(values, Integer.class);
//        checkedTypeValues.add("1"); // 编译错误
        // 运行时 检查
        referencedValues = checkedTypeValues;

        // Exception in thread "main" java.lang.ClassCastException: Attempt to insert class java.lang.String element into collection with element type class java.lang.Integer
        //	at java.util.Collections$CheckedCollection.typeCheck(Collections.java:3037)
        //	at java.util.Collections$CheckedCollection.add(Collections.java:3080)
        //	at com.ajin.deep.in.java.collection.advanced.CheckedTypeCollectionDemo.main(CheckedTypeCollectionDemo.java:46)

        // add时会进行泛型参数检查 类型不通过 插入失败
        referencedValues.add("B");
    }
}
