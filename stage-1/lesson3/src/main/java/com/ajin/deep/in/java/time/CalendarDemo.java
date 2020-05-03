package com.ajin.deep.in.java.time;

import java.util.Calendar;

/**
 * {@link java.util.Calendar} Demo
 *
 * @author ajin
 */

public class CalendarDemo {

    public static void main(String[] args) {
        Calendar calendar = Calendar.getInstance();
        System.out.println("year:" + calendar.get(Calendar.YEAR));
        System.out.println("month:" + calendar.get(Calendar.MONTH));
    }
}
