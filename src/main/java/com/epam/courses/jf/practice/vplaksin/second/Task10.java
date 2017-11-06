package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Task10 implements ITestableTask10 {

    @Override
    public HashMap<String, Integer> countNumberWords(File input) {
        HashMap<String, Integer> result = new HashMap<>();

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                String s = scanner.next();
                if (result.containsKey(s)) {
                    result.put(s, result.get(s) + 1);
                } else {
                    result.put(s, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

}
