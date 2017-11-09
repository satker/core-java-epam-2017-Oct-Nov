package com.epam.courses.jf.practice.akriukov.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;

public class Solver implements ISolver{

    @Override
    public void task1() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int numberOfLines = Integer.parseInt(reader.readLine());
            String[] lines = new String[numberOfLines];

            for (int i = 0; i < numberOfLines; i++) {
                lines[i] = reader.readLine();
            }

            int minLength = lines[0].length();
            int maxLength = lines[0].length();
            String minString = lines[0];
            String maxString = lines[0];

            for (int i = 0; i < numberOfLines; i++) {
                if (minLength >= lines[i].length()) {
                    minLength = lines[i].length();
                    minString = lines[i];
                }
                if (maxLength <= lines[i].length()) {
                    maxLength = lines[i].length();
                    maxString = lines[i];
                }

            }
            System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
            System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void task2() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int numberOfLines = Integer.parseInt(reader.readLine());
            String[] lines = new String[numberOfLines];

            for (int i = 0; i < numberOfLines; i++) {
                lines[i] = reader.readLine();
            }
            Arrays.sort(lines, new compByLength());
            int length;
            String string;
            for (int i = 0; i < numberOfLines; i++) {
                length = lines[i].length();
                string = lines[i];
                System.out.printf("(%d): \"%s\"%n", length, string);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static class compByLength implements Comparator<String> { //comparator for task2
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length()); //firstly compare length
            } else {
                return String.CASE_INSENSITIVE_ORDER.compare(o1, o2); //compare symbols, if same length
            }
        }
    }
}
