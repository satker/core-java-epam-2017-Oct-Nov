package com.epam.courses.jf.practice.asunyaev.second;

import com.epam.courses.jf.practice.common.second.ITestableTask10;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;

public class Task10 implements ITestableTask10 {
    public HashMap<String, Integer> countNumberWords(File input) {
        HashMap<String, Integer> words = new HashMap<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(input))) {
            String string;
            while ((string = reader.readLine()) != null) {
                if (words.containsKey(string)) {
                    words.put(string, words.get(string) + 1);
                } else {
                    words.put(string, 1);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return words;
    }
}
