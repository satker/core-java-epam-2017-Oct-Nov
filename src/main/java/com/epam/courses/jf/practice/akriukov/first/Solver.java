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
            int numberOfLines = Integer.parseInt(readLineFromConsole());

            int minLength = Integer.MAX_VALUE;
            int maxLength = Integer.MIN_VALUE;
            String minString = "";
            String maxString = "";

            for (int i = 0; i < numberOfLines; i++) {
                String s = readLineFromConsole();
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
    }

    @Override
    public void task2() {
        String[] lines = readLinesToStringArray();
        Arrays.sort(lines, new compByLength());
        for (String s: lines) {
            System.out.printf("(%d): \"%s\"%n", s.length(), s);
        }
    }

    @Override
    public void task3() {

    }

    /**
     * Custom comparator for task2()
     * Firstly compares string length. If length is the same, then compare by symbol codes
     */
    static class compByLength implements Comparator<String> {
        public int compare(String o1, String o2) {
            if (o1.length() != o2.length()) {
                return Integer.compare(o1.length(), o2.length()); //compare length
            } else {
                return String.CASE_INSENSITIVE_ORDER.compare(o1, o2); //compare symbols
            }
        }
    }

    /**
     * Reads lines from console
     * Input number of lines first
     * Then input lines
     * @return String[]
     */
    public static String[] readLinesToStringArray() {
            int numberOfLines = Integer.parseInt(readLineFromConsole());
            String[] lines = new String[numberOfLines];

            for (int i = 0; i < numberOfLines; i++) {
                lines[i] = readLineFromConsole();
            }
            return lines;
    }

    /**
     * Reads one line from console
     * @return entered in console line or null
     */
    public static String readLineFromConsole() {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            return reader.readLine();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
}
