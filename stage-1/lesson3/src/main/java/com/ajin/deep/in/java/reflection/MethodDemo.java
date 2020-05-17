package com.ajin.deep.in.java.reflection;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author ajin
 */

public class MethodDemo {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {
        Class<User> userClass = User.class;
        Method[] methods = userClass.getMethods();
        int modifiers = userClass.getModifiers();
        Constructor<?>[] constructors = userClass.getConstructors();
        Constructor constructor = userClass.getConstructor();
        User user = (User)constructor.newInstance();
        Field[] fields = userClass.getFields();
        Class<?>[] interfaces = userClass.getInterfaces();
        Class<? super User> superclass = userClass.getSuperclass();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}
