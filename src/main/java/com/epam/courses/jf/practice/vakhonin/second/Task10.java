package com.epam.courses.jf.practice.vakhonin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

/**
 * Created by igorvahonin on 13.11.17.
 */
public class Task10 implements ITestableTask10{




    @Override
    public HashMap<String, Integer> countNumberWords(File input) {

        String string;
        HashMap<String, Integer> wordsMap = new HashMap<>();

        try (Scanner reader = new Scanner(input)) {
            while (reader.hasNext()) {
                string = reader.next();
                if (wordsMap.containsKey(string)) {
                    wordsMap.put(string, wordsMap.get(string) + 1);
                } else {
                    wordsMap.put(string, 1);
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return wordsMap;
    }
}
