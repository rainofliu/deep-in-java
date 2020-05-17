package com.ajin.deep.in.java.reflection;

import java.lang.reflect.Method;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.List;

/**
 * @author ajin
 */

public class GenericDemo {

    private List<String> list;

    public List<String> returnList() {
        return this.list;
    }

    public static void main(String[] args) throws NoSuchMethodException {
        Class<GenericDemo> genericDemoClass = GenericDemo.class;
        Method method = genericDemoClass.getMethod("returnList", null);
        Type genericReturnType = method.getGenericReturnType();
        if (genericReturnType instanceof ParameterizedType) {
            ParameterizedType parameterizedType = (ParameterizedType) genericReturnType;
            Type[] typeArguments = parameterizedType.getActualTypeArguments();
            for (Type typeArgument : typeArguments) {
                Class argument = (Class) typeArgument;
                // class java.lang.String
                System.out.println(argument);
            }
        }
    }
}
