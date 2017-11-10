package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask2;

import java.io.File;
import java.io.IOException;
import java.nio.file.*;
import java.nio.file.attribute.BasicFileAttributes;
import java.util.HashSet;
import java.util.Set;

public class Task2Impl implements ITestableTask2 {
    @Override
    public Set<File> getFiles(File directory) {
        Set<File> result = new HashSet<>();
        Path path = Paths.get(directory.getAbsolutePath());
        try {
            Files.walkFileTree(path, new MyFileVisitor(result, path));
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
        return result;
    }

    class MyFileVisitor extends SimpleFileVisitor<Path> {

        Set<File> result;
        Path root;

        public MyFileVisitor(Set<File> result, Path root) {
            this.result = result;
            this.root = root;
        }

        @Override
        public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException {
            result.add(file.toFile());
            return FileVisitResult.CONTINUE;
        }

        @Override
        public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException { // or use previsit
            if (dir != root) // do not count root directory
                result.add(dir.toFile());
            return FileVisitResult.CONTINUE;
        }
    }
}
