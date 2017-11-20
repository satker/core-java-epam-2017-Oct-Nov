package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.*;
import java.util.*;

public class Task1 implements ITestableTask1 {
    @Override
    public List<String> reverseFile(File input, File output) {
        List<String> strings = new ArrayList<>();
        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String line = bufferedReader.readLine();
            strings.add(line);
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(strings);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            for (int i = 0; i < strings.size(); i++) {
                bufferedWriter.write(strings.get(i));
                bufferedWriter.newLine();
                bufferedWriter.flush();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(strings);
        return strings;
    }
}
