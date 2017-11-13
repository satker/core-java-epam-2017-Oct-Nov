package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class Task1Impl implements ITestableTask1 {

    @Override
    public List<String> reverseFile(File input, File output) {
        List<String> forwardStringsList;
        try (FileWriter fw = new FileWriter(output)) {
            forwardStringsList = Files.readAllLines(Paths.get(input.getAbsolutePath()));
            for (int i = forwardStringsList.size() - 1; i >= 0; --i) {
                fw.write(forwardStringsList.get(i));
                fw.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }

        return forwardStringsList;
    }
}