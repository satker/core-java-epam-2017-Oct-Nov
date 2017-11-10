package com.epam.courses.jf.practice.mallayarov.second;

import com.epam.courses.jf.practice.common.second.ITestableTask9;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;

public class Task9Impl implements ITestableTask9 {
    @Override
    public HashSet<String> getUniqueWords(File input) {
        HashSet<String> result = new HashSet<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line.toLowerCase());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return result;
    }
}
