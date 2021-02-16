package com.ajin.deep.in.java.io.filesystem.nio;

import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;

/**
 * @author ajin
 */

public class FindVisitor extends SimpleFileVisitor<Path> {

    private final PathMatcher pathMatcher;

    private int foundCount;

    public FindVisitor(String pattern) {
        this.pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" +pattern);
    }

    public int getFoundCount() {
        return foundCount;
    }

    @Override
    public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException {
        matchFile(dir);
        return FileVisitResult.CONTINUE;
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        matchFile(file);
        return FileVisitResult.CONTINUE;
    }

    private void matchFile(Path file) {
        Path name = file.getFileName();
        if (name != null && pathMatcher.matches(name)) {
            foundCount++;
            System.out.printf("Found file : %s \n",file);
        }
    }
}
