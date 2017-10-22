package com.epam.courses.jf.practice.common.first;

import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;

public class Solver implements ISolver {

    private static String[] readStrings(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());

        String[] result = new String[n];
        for (int i = 0; i < n; i++) {
            result[i] = scanner.nextLine();
        }

        return result;

    }

    @Override
    public void task1() {

        String[] strings = readStrings(new Scanner(System.in));

        String minString = strings[0];
        String maxString = strings[0];
        int minLength = minString.length();
        int maxLength = maxString.length();

        for (String s : strings) {
            if (s.length() <= minLength) {
                minString = s;
                minLength = s.length();
            }

            if (s.length() >= maxLength) {
                maxString = s;
                maxLength = s.length();
            }
        }

        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);

    }

    @Override
    public void task2() {

        String[] strings = readStrings(new Scanner(System.in));

        Arrays.sort(strings, Comparator.comparingInt(String::length).thenComparing(String::compareTo));

        for (String s : strings) {
            System.out.printf("(%d): \"%s\"%n", s.length(), s);
        }

    }

    @Override
    public void task3() {

        String[] strings = readStrings(new Scanner(System.in));

        long averageLength = 0L;
        for (String s : strings) {
            averageLength += s.length();
        }
        averageLength /= strings.length;
        System.out.printf("AVERAGE (%d)%n", averageLength);

        for (String s : strings) {
            if (s.length() < averageLength) {
                System.out.printf("(%d): \"%s\"%n", s.length(), s);
            }
        }

    }

    @Override
    public void task4() {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] words = scanner.nextLine().split(" ");
        int minDifference = 2 * 26 + 1; //Number of different symbols in english alphabet + 1
        String result = "";

        for (String s : words) {
            char[] chars = s.toCharArray();
            HashSet<Character> set = new HashSet<>();

            for (Character c : chars) {
                set.add(c);
            }

            if (set.size() < minDifference) {
                result = s;
                minDifference = set.size();
            }
        }

        System.out.println(result);

    }

    @Override
    public void task5() {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String[] words = scanner.nextLine().split(" ");

        final Character[] temp = {'a', 'e', 'i', 'o', 'u', 'y'};
        final List<Character> vowels = Arrays.asList(temp);
        int result = 0;

        for (String s : words) {
            char[] chars = s.toLowerCase().toCharArray();
            int vowelCount = 0;
            int consonantCount = 0;
            boolean isLatin = true;

            for (Character c : chars) {
                if (c <= 'z' && c >= 'a') {
                    if (vowels.contains(c)) {
                        vowelCount++;
                    } else {
                        consonantCount++;
                    }
                } else {
                    isLatin = false;
                    break;
                }
            }

            if (isLatin && consonantCount == vowelCount) {
                result++;
            }
        }

        System.out.println(result);

    }

    public static void main(String[] args) {
        new Solver().task5();
    }
}
