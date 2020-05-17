package com.ajin.deep.in.java.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

/**
 * JDK动态代理Demo
 *
 * @author ajin
 */

public class InvocationDemo {
    public static void main(String[] args) {
        InvocationHandler invocationHandler = new MyInvocationHandler();
        DemoInterface proxyInstance = (DemoInterface) Proxy.newProxyInstance(DemoInterface.class.getClassLoader(),
                new Class[]{DemoInterface.class}, invocationHandler);
        proxyInstance.set();
    }
}
