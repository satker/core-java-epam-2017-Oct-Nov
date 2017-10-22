package com.epam.courses.jf.practice.common.first;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

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

    private static String[] readWords(Scanner scanner) {

        int n = Integer.parseInt(scanner.nextLine());
        return scanner.nextLine().split(" ");

    }

    @Override
    public void task4() {

        String[] words = readWords(new Scanner(System.in));
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

        String[] words = readWords(new Scanner(System.in));

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

    @Override
    public void task6() {

        String[] words = readWords(new Scanner(System.in));

        loop:
        for (String s : words) {
            char[] chars = s.toCharArray();

            if (chars.length == 1) {
                continue;
            }

            for (int j = 0; j < chars.length - 1; j++) {
                if (chars[j] >= chars[j + 1]) {
                    continue loop;
                }
            }

            System.out.println(s);
            return;
        }

        System.out.println("NOT FOUND");

    }

    @Override
    public void task7() {

        String[] words = readWords(new Scanner(System.in));
        HashSet<String> wordSet = new HashSet<>();
        StringBuilder builder = new StringBuilder();

        loop:
        for (String s : words) {
            char[] chars = s.toCharArray();
            HashSet<Character> charSet = new HashSet<>();

            for (char c : chars) {
                if (!charSet.add(c)) {
                    continue loop;
                }
            }

            if (wordSet.add(s)) {
                if (builder.length() == 0) {
                    builder.append(s);
                } else {
                    builder.append(" ");
                    builder.append(s);
                }
            }

        }

        if (builder.length() != 0) {
            System.out.println(builder.toString());
        } else {
            System.out.println("NOT FOUND");
        }

    }

    @Override
    public void task8() {

        String[] words = readWords(new Scanner(System.in));
        List<BigInteger> polyndroms = new ArrayList<>();

        loop:
        for (String s : words) {
            char[] chars = s.toCharArray();
            for (char c : chars) {
                if (!(c <= '9' && c >= '0')) {
                    continue loop;
                }
            }
            BigInteger number = new BigInteger(s);

            if (s.equals(new StringBuilder(s).reverse().toString())) {
                polyndroms.add(number);
            }
        }

        if (polyndroms.size() == 1) {
            System.out.println(polyndroms.get(0));
        } else if (polyndroms.size() > 1) {
            System.out.println(polyndroms.get(1));
        } else {
            System.out.println("NOT FOUND");
        }

    }

    private static int[][] readMatrix(Scanner scanner) {

        final int DIMENSION = scanner.nextInt();
        int[][] matrix = new int[DIMENSION][DIMENSION];

        for (int row = 0; row < DIMENSION; row++) {
            for (int col = 0; col < DIMENSION; col++) {
                matrix[row][col] = scanner.nextInt();
            }
        }

        return matrix;

    }

    private static void printMatrix(int[][] input) {

        for (int[] row : input) {
            for (int i = 0; i < row.length; i++) {
                if (i != row.length - 1) {
                    System.out.print(row[i] + "\t");
                } else {
                    System.out.println(row[i]);
                }
            }
        }

    }

    @Override
    public void task9() {

        Scanner scanner = new Scanner(System.in);
        final int n = Integer.parseInt(scanner.nextLine());

        int[][] result = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[i][j] = i * n + j + 1;
            }
        }

        printMatrix(result);

    }

    public static void main(String[] args) {
        new Solver().task9();
    }
}
