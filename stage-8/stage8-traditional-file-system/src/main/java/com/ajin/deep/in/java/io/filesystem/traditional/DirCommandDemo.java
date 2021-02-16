package com.ajin.deep.in.java.io.filesystem.traditional;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.io.File;
import java.util.stream.Stream;

/**
 * 模拟 cmd的<code>dir</code>命令
 *
 * @author ajin
 * @see File#listFiles()
 * @see File#length()
 */
public class DirCommandDemo {

    private final File rootDirectory;

    public DirCommandDemo(File rootDirectory) {
        this.rootDirectory = rootDirectory;
    }

    public void execute() {
        File[] listFiles = rootDirectory.listFiles();
        if (listFiles == null) {
            return;
        }
        // 2019/08/03  16:07    <DIR>          .3T
        // 2021/02/08  20:48            16,150 .bash_history
        Stream.of(listFiles).map(file -> {
            StringBuilder fileMessage  = new StringBuilder();
            long          lastModified = file.lastModified();
            String        dir          = file.isDirectory() ? "<DIR>" : "     ";
            String        fileLength   = file.isDirectory() ? "0" : String.valueOf(file.length());
            String        fileName     = file.getName();
            String        dateFormat   = DateFormatUtils.format(lastModified, "yyyy-MM-dd HH:mm:ss");

            return fileMessage.append(dateFormat).append(" ").append(dir).append("   ").append(fileLength).append(" ")
                .append(fileName).toString();
        }).forEach(System.out::println);
    }

    public static void main(String[] args) {
        DirCommandDemo dirCommandDemo = new DirCommandDemo(new File("C:\\Users\\ajin"));
        dirCommandDemo.execute();
    }
}
