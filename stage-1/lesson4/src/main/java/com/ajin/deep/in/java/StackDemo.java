package com.ajin.deep.in.java;

import java.util.Stack;

/**
 * @author ajin
 *
 */
@Deprecated
public class StackDemo {
    public static void main(String[] args) {
        Stack<String> stack=new Stack<>();
        stack.add("a");
        stack.add("b");
        System.out.println(stack.pop());
    }
}
