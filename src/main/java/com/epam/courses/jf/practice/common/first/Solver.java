package com.epam.courses.jf.practice.common.first;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.MathContext;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;
import java.util.Scanner;
import java.util.List;
import java.util.ArrayList;

import static java.lang.Math.max;
import static java.lang.Math.sqrt;

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

        System.out.println(input.length);
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

    @Override
    public void task10() {

        Scanner scanner = new Scanner(System.in);
        final int A = scanner.nextInt();
        final int B = scanner.nextInt();
        final int C = scanner.nextInt();

        final double D = B * B - 4 * A * C;
        if (D < 0) {
            System.out.println("No solution");
        } else if (D == 0) {
            BigDecimal result = new BigDecimal((double) -B / (2 * A));
            result = result.round(new MathContext(2, RoundingMode.HALF_UP));
            System.out.println("One solution: " + result);
        } else {
            BigDecimal result1 = new BigDecimal((-B - sqrt(D)) / (2 * A));
            BigDecimal result2 = new BigDecimal((-B + sqrt(D)) / (2 * A));
            result1 = result1.round(new MathContext(2, RoundingMode.HALF_UP));
            result2 = result2.round(new MathContext(2, RoundingMode.HALF_UP));
            System.out.println("Two solutions: " + result1 + ", " + result2);
        }

    }

    @Override
    public void task11() {

        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        char[] chars = input.toCharArray();

        for (char c : chars) {
            if (c > '9' || c < '0') {
                System.out.println("INCORRECT INPUT DATA");
                return;
            }
        }

        int monthNumber = Integer.parseInt(input);

        switch (monthNumber) {
            case 1:
                System.out.println("January");
                break;
            case 2:
                System.out.println("February");
                break;
            case 3:
                System.out.println("March");
                break;
            case 4:
                System.out.println("April");
                break;
            case 5:
                System.out.println("May");
                break;
            case 6:
                System.out.println("June");
                break;
            case 7:
                System.out.println("July");
                break;
            case 8:
                System.out.println("August");
                break;
            case 9:
                System.out.println("September");
                break;
            case 10:
                System.out.println("October");
                break;
            case 11:
                System.out.println("November");
                break;
            case 12:
                System.out.println("December");
                break;
            default:
                System.out.println("INCORRECT INPUT DATA");
                break;
        }

    }

    @Override
    public void task12() {

        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner);

        Arrays.sort(matrix, Comparator.comparingInt(arr -> arr[k]));

        printMatrix(matrix);

    }

    @Override
    public void task13() {

        Scanner scanner = new Scanner(System.in);
        int k = Integer.parseInt(scanner.nextLine());
        int[][] matrix = readMatrix(scanner);
        int[][] result = new int[matrix.length][];


        for (int i = 0; i < result.length; i++) {
            int positionInMatrix = (i - k) % result.length;
            positionInMatrix = positionInMatrix < 0 ? positionInMatrix + result.length : positionInMatrix;
            result[i] = matrix[positionInMatrix].clone();
        }

        printMatrix(result);

    }

    @Override
    public void task14() {

        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[] numbers = new int[n];
        for (int i = 0; i < n; i++) {
            numbers[i] = scanner.nextInt();
        }

        int maxRow = 1;
        int tempRow = 1;
        if (n == 1) {
            System.out.println(n);
            return;
        }

        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] > numbers[i - 1]) {
                tempRow++;
            } else {
                maxRow = max(maxRow, tempRow);
                tempRow = 1;
            }
        }

        System.out.println(maxRow);

    }

    @Override
    public void task15() {

        Scanner scanner = new Scanner(System.in);
        int[][] matrix = readMatrix(scanner);

        int result = 0;
        for (int[] row : matrix) {
            int sumBetweenPositivs = 0;
            boolean wasPositive = false;

            for (int element : row) {
                if (!wasPositive) {
                    if (element > 0) {
                        wasPositive = true;
                    }
                } else {
                    if (element > 0) {
                        result += sumBetweenPositivs;
                        break;
                    } else {
                        sumBetweenPositivs += element;
                    }
                }
            }
        }

        System.out.println(result);

    }

    @Override
    public void task16() {

        int[][] matrix = readMatrix(new Scanner(System.in));
        int[][] result = new int[matrix.length][matrix[0].length];

        for (int i = 0; i < result.length; i++) {
            for (int j = 0; j < result[0].length; j++) {
                result[i][j] = matrix[j][matrix.length - 1 - i];
            }
        }

        printMatrix(result);

    }

    public static void main(String[] args) {
        new Solver().task16();
    }
}
