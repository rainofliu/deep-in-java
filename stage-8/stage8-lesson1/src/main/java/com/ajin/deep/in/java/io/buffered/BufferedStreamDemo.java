package com.ajin.deep.in.java.io.buffered;

/**
 * <pre>
 *    到目前为止，我们看到的大多数示例都使用了未缓冲的I/O。这意味着每个读或写请求都由底层操作系统直接处理。
 * 这可能会使程序的效率大大降低，因为每次这样的请求都会触发磁盘访问、网络活动或其他一些相对昂贵的操作。
 *
 *   为了减少这种开销，Java平台实现了缓冲I/O流。被缓冲的输入流 从 称为缓冲区的内存区域 读取数据; 只有当缓冲区为空时 才调用底层 Input API
 * 类似地，被缓冲的输出流 将数据写入 缓冲区，仅在缓冲区满时 才调用底层 Output API。</pre>
 *
 * @author ajin
 * @see java.io.BufferedInputStream
 * @see java.io.BufferedOutputStream
 */

public class BufferedStreamDemo {

    public static void main(String[] args) {


    }
}
