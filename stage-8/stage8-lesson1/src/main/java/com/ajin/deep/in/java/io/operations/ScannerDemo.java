package com.ajin.deep.in.java.io.operations;

import java.io.StringReader;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * @author ajin
 * @see java.util.Scanner
 */

public class ScannerDemo {

    public static void main(String[] args) {
        StringReader stringReader = new StringReader("1,2,3,4,5");

        Scanner scanner = new Scanner(stringReader);
        // 替换默认分隔符
        scanner.useDelimiter(",");

        while (scanner.hasNext()) {
            String next = scanner.next();
            System.out.println(next);
        }
    }
}
