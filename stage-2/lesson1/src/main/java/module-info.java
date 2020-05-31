module lesson1 {
    // 命名模块
    // requires 可读性
    requires java.base; // 默认依赖
    requires java.sql;  // 传递依赖 requires transitive
    requires java.compiler; // exports 控制可访问的API 包
    // exports 可访问性 供外部访问
    exports com.ajin.deep.in.java.modular; // 导出依赖

    // 非命名模块
    requires spring.context; // Maven artifactId  -  -> .
    requires org.apache.commons.lang3;
}