package com.ajin.deep.in.java.functional.design;

import java.util.function.Supplier;

/**
 * {@link java.util.function.Supplier} 设计
 *
 * @author ajin
 */

public class SupplierDesignDemo {

    public static void main(String[] args) {
        echo("Hello,World"); // 固定的参数

        echo(() -> {
            sleep(1000L);
            return "Labmda,HelloWorld";
        });
        // 可以延迟加载 这种方式更灵活
        echo(SupplierDesignDemo::getMessage); // 变化的实现

        // 即时返回
        getMessage();

        // 延时返回
        Supplier<String> message = supplierMessage(); // 待执行
        message.get(); // 实际执行
    }

    private static void sleep(long millis) {
        try {
            Thread.sleep(millis);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    private static String getMessage() {
        sleep(1000L);
        return "Labmda,HelloWorld";
    }

    private static Supplier<String> supplierMessage() {
        return SupplierDesignDemo::getMessage;
    }

    public static void echo(String message) { // 拉的模式
        System.out.println(message);
    }

    public static void echo(Supplier<String> message) { // 推的模式
        System.out.println(message.get());
    }

}
