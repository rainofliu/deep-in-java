package com.ajin.deep.in.java.time;

import java.util.TimeZone;

/**
 * {@link TimeZone}时区 Demo
 *
 * @author ajin
 */

public class TimeZoneDemo {

    public static void main(String[] args) {
        TimeZone defaultTimeZone = TimeZone.getDefault();
        System.out.println(defaultTimeZone.getID());
        System.out.println(System.getProperty("user.timezone"));
    }
}
