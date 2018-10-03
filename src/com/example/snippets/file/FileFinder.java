package com.example.snippets.file;

import java.io.IOException;
import java.nio.file.FileSystems;
import java.nio.file.FileVisitResult;
import java.nio.file.Path;
import java.nio.file.PathMatcher;
import java.nio.file.SimpleFileVisitor;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.ArrayList;

public class FileFinder extends SimpleFileVisitor<Path> {

    public ArrayList<Path> foundPath = new ArrayList<>();
    private PathMatcher pathMatcher;

    public FileFinder(String pattern) {
        // with glob or regex
        this.pathMatcher = FileSystems.getDefault().getPathMatcher("glob:" + pattern);
    }

    @Override
    public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
        Path name = file.getFileName();
        System.out.println("reporting :" + name);
        if (this.pathMatcher.matches(name)) {
            this.foundPath.add(file);
        }

        return FileVisitResult.CONTINUE;

    }

}
