package com.ajin.deep.in.java.reflection;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author ajin
 */

public class MyInvocationHandler implements InvocationHandler {
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("test");
        return null;
    }
}
