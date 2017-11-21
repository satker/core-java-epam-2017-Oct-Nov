package com.epam.courses.jf.practice.SigarevVL.second;

import com.epam.courses.jf.practice.common.second.ITestableTask10;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Task10 implements ITestableTask10{

    @Override
    public HashMap<String, Integer> countNumberWords(File input) {
        HashMap<String, Integer>  wordsMap = new HashMap<>();
        StringBuilder stringBuilder = new StringBuilder();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(input))) {
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                stringBuilder.append(line).append(" ");
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String allWords[] = stringBuilder.toString().split(" ");
        for (String string : allWords) {
            if (wordsMap.containsKey(string)) {
                wordsMap.put(string, wordsMap.get(string) + 1);
            } else {
                wordsMap.put(string, 1);
            }
        }

        return wordsMap;
    }
}
