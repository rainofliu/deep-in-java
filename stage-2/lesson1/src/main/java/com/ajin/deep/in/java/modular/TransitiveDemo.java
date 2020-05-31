package com.ajin.deep.in.java.modular;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.logging.Logger;

/**
 * @author ajin
 */

public class TransitiveDemo {
    public static void main(String[] args) {
        Logger logger = Logger.getLogger("main");
        logger.info("helloworld");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext();
    }
}
