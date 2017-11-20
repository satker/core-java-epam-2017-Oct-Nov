package com.epam.courses.jf.practice.desided.second;

import com.epam.courses.jf.practice.common.second.ITaskStorage;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

public class Task2 implements ITaskStorage.ITestableTask {
    public Set<File> getFiles(File directory) throws IOException {

        Set<File> fileSet = new HashSet<>();

        fileSet = Files.walk(directory.toPath())
                .map(Path::toFile)
                .collect(Collectors.toSet());

        return fileSet;
    }
}
