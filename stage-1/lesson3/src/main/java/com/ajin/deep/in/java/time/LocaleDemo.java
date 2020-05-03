package com.ajin.deep.in.java.time;

import java.util.Locale;

/**
 * {@link java.util.Locale}Demo
 * @author ajin
 */

public class LocaleDemo {
    public static void main(String[] args) {
        Locale locale = Locale.getDefault();
        // zh_CN
        System.out.println(locale.toString());
    }
}
