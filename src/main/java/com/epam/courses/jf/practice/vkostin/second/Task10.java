package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask10;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Scanner;

public class Task10 implements ITestableTask10 {

    /*
    public static void main(String[] args) {
        Task10 task = new Task10();
        System.out.println(task.countNumberWords(new File("full pathname")));
    }
    */

    @Override
    public HashMap<String, Integer> countNumberWords(File input) {
        HashMap<String, Integer> dictionary = new HashMap<>();

        String currentWord;

        try (Scanner scanner = new Scanner(input)) {

            while (scanner.hasNext()) {
                currentWord = scanner.next().trim();
                if (!dictionary.containsKey(currentWord)) {
                    dictionary.put(currentWord, 1);
                } else {
                    dictionary.put(currentWord, dictionary.get(currentWord) + 1);
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return dictionary;
    }
}
