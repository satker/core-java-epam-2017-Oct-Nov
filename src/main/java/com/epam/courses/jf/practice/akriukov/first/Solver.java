package com.epam.courses.jf.practice.akriukov.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Set;

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
        int averageLength =0;
        String[] lines = readLinesToStringArray();

        for (String string: lines) {
            averageLength += string.length();
        }
        averageLength /= lines.length;
        System.out.printf("AVERAGE (%d)%n", averageLength);

        for (String string: lines) {
            if (averageLength > string.length()) {
                System.out.printf("(%d): \"%s\"%n", string.length(), string);
            }
        }
    }

    @Override
    public void task4() {
        int numberOfWords = Integer.parseInt(readLineFromConsole());
        int minNumberOfLetters = Integer.MAX_VALUE;
        String minNumberOfLetterString = "";
        String[] strings = readLineFromConsole().split(" ");
        for (String s : strings) {
            Set<Character> word = new HashSet<>();
            for (int i = 0; i < s.length(); i++) {
                word.add(s.charAt(i));
            }
            if (minNumberOfLetters > word.size()) {
                minNumberOfLetters = word.size();
                minNumberOfLetterString = s;
            }
        }
        System.out.println(minNumberOfLetterString);
    }

    @Override
    public void task5() {
        int numberOfWords = Integer.parseInt(readLineFromConsole());
        Set<Character> vowels = new HashSet<>();
        vowels.add('a');
        vowels.add('e');
        vowels.add('i');
        vowels.add('o');
        vowels.add('u');
        vowels.add('y');
        String[] strings = readLineFromConsole().split(" ");
        int wordsWithEqualVowelsNConsonants = 0;

        for (String str : strings) {
            int vowelCountInWord = 0;
            boolean latinFlag = true; //false if nonLatin letter detected
            for (int i = 0; i < str.length(); i++) {
                char currentSymbol = Character.toLowerCase(str.charAt(i)); //using lowercase to minimize check
                int charIntValue = (int) currentSymbol;
                if ((charIntValue > 96) && //character must be latin
                        (charIntValue < 123)) {
                    if (vowels.contains(currentSymbol)) {
                        vowelCountInWord++;
                    }
                } else {
                    latinFlag = false; //nonLatin letter detected
                    break;
                }
            }
            if (((str.length() - vowelCountInWord) == vowelCountInWord) && //pass with no actions if nonLatin letter detected
                    latinFlag){
                wordsWithEqualVowelsNConsonants++;
            }
        }
        System.out.println(wordsWithEqualVowelsNConsonants);
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
