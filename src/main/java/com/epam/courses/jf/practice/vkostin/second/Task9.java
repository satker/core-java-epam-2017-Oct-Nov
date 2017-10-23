package com.epam.courses.jf.practice.vkostin.second;

import com.epam.courses.jf.practice.common.second.ITestableTask9;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashSet;
import java.util.Scanner;


public class Task9 implements ITestableTask9 {

    /*
    public static void main(String[] args)
    throws IOException {
        Task9 task = new Task9();
        System.out.println(task.getUniqueWords(new File("pathname")));
    }
    */

    @Override
    public HashSet<String> getUniqueWords(File input) {
        HashSet<String> set = new HashSet<>();
        try (Scanner scanner = new Scanner(input)) {
            while (scanner.hasNext()) {
                set.add(scanner.next()
                        .trim()             // remove white spaces
                        .toLowerCase());    // lower case
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        return set;
    }
}
