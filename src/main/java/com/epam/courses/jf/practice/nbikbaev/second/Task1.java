package com.epam.courses.jf.practice.nbikbaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask1;

import java.io.*;
import java.util.*;

public class Task1 implements ITestableTask1 {
    @Override
    public List<String> reverseFile(File input, File output) {
        List<String> strings = new ArrayList<>();
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                strings.add(scanner.next());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(strings);
        try (BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(output))) {
            for (String string : strings) {
                bufferedWriter.write(string);
                bufferedWriter.newLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        Collections.reverse(strings);
        return strings;
    }
}
