package com.ajin.deep.in.java.modular;

import java.lang.module.ModuleDescriptor;
import java.util.logging.Logger;

/**
 * 模块化反射Demo
 *
 * @author ajin
 */

public class ModuleReflectionDemo {

    public static void main(String[] args) {

        Class<Logger> loggerClass = Logger.class;

        Module module = loggerClass.getModule();

        String moduleName = module.getName();
        System.out.printf("%s 类存在于模块%s 中\n", loggerClass.getName(), moduleName);

        ModuleDescriptor moduleDescriptor = module.getDescriptor();
        moduleDescriptor.requires().forEach(require ->
                System.out.println(require.modifiers())
        );
    }
}
