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

            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;
            String minString = "";
            String maxString = "";

            for (int i = 0; i < numberOfLines; i++) {
                String s = reader.readLine();
                if (minLength >= s.length()) {
                    minLength = s.length();
                    minString = s;
                }
                if (maxLength <= s.length()) {
                    maxLength = s.length();
                    maxString = s;
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

    @Override
    public void task3() {

    }

    public static String[] readLinesToStringArray() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            int numberOfLines = Integer.parseInt(reader.readLine());
            String[] lines = new String[numberOfLines];

            for (int i = 0; i < numberOfLines; i++) {
                lines[i] = reader.readLine();
            }
            return lines;
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
