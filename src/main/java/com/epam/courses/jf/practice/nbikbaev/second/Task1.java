package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

public class Task1 implements ITestableTask1 {
    @Override
    public List<String> reverseFile(File input, File output) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String line = bufferedReader.readLine();
            strings.add(line);
        } catch (IOException e) {
            System.err.println(e);
        }
        Collections.reverse(strings);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            for (String s : strings) {
                bufferedWriter.write(s);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            System.err.println(e);
        }
        Collections.reverse(strings);
        return strings;
    }
}
