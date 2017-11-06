package com.epam.courses.jf.practice.vplaksin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;

public class Task9 implements ITestableTask9 {

    @Override
    public HashSet<String> getUniqueWords(File input) {
        HashSet<String> result = new HashSet<>();

        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()){
                result.add(scanner.next().toLowerCase());
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return result;
    }

}
