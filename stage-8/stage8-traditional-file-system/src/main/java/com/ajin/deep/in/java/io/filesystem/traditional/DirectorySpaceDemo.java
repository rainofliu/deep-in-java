package com.ajin.deep.in.java.io.filesystem.traditional;

import java.io.File;
import java.io.FileFilter;
import java.util.Objects;
import java.util.function.Predicate;
import java.util.stream.Stream;

/**
 * 计算一个目录占据的空间
 *
 * @author ajin
 */
public class DirectorySpaceDemo {

    /**
     * 根目录
     * */
    private final File            rootDirectory;
    /**
     * {@link Predicate}
     * */
    private final Predicate<File> filter;

    public DirectorySpaceDemo(File rootDirectory, FileFilter... fileFilters) {
        this.rootDirectory = rootDirectory;
        this.filter = new FilePredicate(fileFilters);
    }


    private class FilePredicate implements Predicate<File> {

        private final FileFilter[] fileFilters;

        public FilePredicate(FileFilter[] fileFilters) {
            this.fileFilters = fileFilters;
        }

        @Override
        public boolean test(File file) {

            for (FileFilter fileFilter : fileFilters) {
                if (!fileFilter.accept(file)) {
                    return false;
                }
            }

            return true;
        }
    }

    private interface FilePredicateAdapter extends Predicate<File>, FileFilter {

        @Override
        default boolean accept(File pathname) {
            return test(pathname);
        }

    }

    /**
     * 获取路径对应 的 大小 比如：d:\\test 占据内存 128kb
     */
    public long getSpace() {
        if (rootDirectory.isFile()) {
            return rootDirectory.length();
        } else if (rootDirectory.isDirectory()) {
            File[] subFiles = rootDirectory.listFiles();
            long   space    = 0L;
            if (null == subFiles) {
                return space;
            }
            // 累加当前目录的文件
            space += Stream.of(subFiles).filter(File::isFile).filter(filter).map(File::length).reduce(Long::sum).orElse(
                0L);

            // 递归当前子目录
            space += Stream.of(subFiles).filter(File::isDirectory).filter(filter).map(DirectorySpaceDemo::new).map(
                DirectorySpaceDemo::getSpace).reduce(Long::sum).orElse(0L);

            return space;
        }
        return -1L;
    }

    public static long calculateSpace(File file) {
        Objects.requireNonNull(file);

        if (file.isFile()) {
            return file.length();
        } else if (file.isDirectory()) {

            long filesSpace = 0L;

            File[] subFiles = file.listFiles();
            if (null == subFiles) {
                return filesSpace;
            }

            for (File subFile : subFiles) {
                filesSpace += calculateSpace(subFile);
            }
            return filesSpace;
        }
        return -1L;
    }

    public static void main(String[] args) {

        System.out.println(
            new DirectorySpaceDemo(new File(System.getProperty("user.home")), file -> file.getName().endsWith(".log"))
                .getSpace() / 1024);

    }
}
