package com.epam.courses.jf.practice.asgalantsev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.File;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Stack;

public class Task1 implements ITestableTask1 {

    @Override
    public List<String> reverseFile(File input, File output) {
        List<String> lines = null;
        List<String> reverseFile = new Stack<>();
        try {
            lines = Files.readAllLines(Paths.get(input.toURI()), Charset.defaultCharset());
        } catch (IOException e) {}
        for (String s : lines) {
            reverseFile.add(s);
        }
        return reverseFile;
    }
}
