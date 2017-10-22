package com.epam.courses.jf.practice.common.first;

import java.util.Scanner;

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

        Scanner scanner = new Scanner(System.in);
        String[] strings = readStrings(scanner);

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

    public static void main(String[] args) {
        new Solver().task1();
    }
}
