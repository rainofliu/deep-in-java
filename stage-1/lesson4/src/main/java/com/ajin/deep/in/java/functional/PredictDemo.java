package com.ajin.deep.in.java.functional;

import java.io.File;
import java.util.function.Predicate;

/**
 * @author ajin
 */

public class PredictDemo {

    public static void main(String[] args) {
        Predicate<File> predicate = File::isFile;
    }
}
