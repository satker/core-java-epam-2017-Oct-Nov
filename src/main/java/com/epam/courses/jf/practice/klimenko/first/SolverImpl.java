package com.epam.courses.jf.practice.klimenko.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.util.*;

public class SolverImpl implements ISolver {
    @Override
    public void task1() {
        int minLength = -1, maxLength = -1;
        String minString = "???", maxString = "???";
        Scanner scanner = new Scanner(System.in);
        int linesNumber = scanner.nextInt();

        scanner.nextLine();
        for (int i = 0; i < linesNumber; ++i) {
            String currentString = scanner.nextLine();
            if (minLength == -1 || currentString.length() < minLength) {
                minLength = currentString.length();
                minString = currentString;
            }
            if (maxLength == -1 || currentString.length() > maxLength) {
                maxLength = currentString.length();
                maxString = currentString;
            }
        }

        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }

    @Override
    public void task2() {
        List<String> list = readLines(new Scanner(System.in));

        list.sort(Comparator
                .comparing((String str) -> str.length())
                .thenComparing(str -> str)
        );

        for (String string : list) {
            System.out.println(string);
        }
    }

    @Override
    public void task3() {
        List<String> list = readLines(new Scanner(System.in));
        int sumOfLengths = 0;
        int averageLength;

        for (String string : list) {
            sumOfLengths += string.length();
        }
        averageLength = sumOfLengths / list.size();

        System.out.printf("AVERAGE (%d)%n", averageLength);
        for (String string : list) {
            if (string.length() < averageLength) {
                System.out.printf("(%d): \"%s\"%n", string.length(), string);
            }
        }
    }

    @Override
    public void task4() {
        List<String> words = readWords(new Scanner(System.in));
        String minWord = "???";
        int minCharset = -1;

        for (String word : words) {
            Set<Character> charset = new HashSet<>();
            for (int i = 0; i < word.length(); ++i) {
                charset.add(word.charAt(i));
            }
            if (minCharset == -1 || charset.size() < minCharset) {
                minCharset = charset.size();
                minWord = word;
            }
        }

        System.out.println(minWord);
    }

    @Override
    public void task5() {
        List<String> words = readWords(new Scanner(System.in));
        int matchedWordsCount = 0;
        String vowels = "aeiouy";

        for (String word : words) {
            boolean alphaOnly = true;
            int vowelsCount = 0;
            for (int i = 0; i < word.length(); ++i) {
                char c = word.charAt(i);
                if (!Character.isAlphabetic(c)) {
                    alphaOnly = false;
                    break;
                }
                if (vowels.indexOf(Character.toLowerCase(c)) >= 0) {
                    ++vowelsCount;
                }
            }
            if (alphaOnly && vowelsCount == word.length() - vowelsCount) {
                ++matchedWordsCount;
            }
        }

        System.out.println(matchedWordsCount);
    }

    @Override
    public void task6() {
        List<String> words = readWords(new Scanner(System.in));
        String matchedWord = "";

        for (String word : words) {
            boolean sorted = word.length() > 1;
            for (int i = 1; i < word.length(); ++i) {
                // TODO: Convert to lowercase before comparing codes
                if (word.codePointAt(i - 1) >= word.codePointAt(i)) {
                    sorted = false;
                    break;
                }
            }
            if (sorted) {
                matchedWord = word;
                break;
            }
        }

        System.out.println(matchedWord);
    }

    @Override
    public void task7() {
        List<String> words = readWords(new Scanner(System.in));
        Set<String> matchedWords = new HashSet<>();

        for (String word : words) {
            Set<Character> charset = new HashSet<>();
            boolean matched = true;

            for (int i = 0; i < word.length(); ++i) {
                Character c = Character.toLowerCase(word.charAt(i));
                if (charset.contains(c)) {
                    matched = false;
                    break;
                }
                charset.add(c);
            }

            if (matched) {
                if (!matchedWords.contains(word)) {
                    System.out.printf("%s ", word);
                    matchedWords.add(word);
                }
            }
        }
    }

    @Override
    public void task8() {
        List<String> words = readWords(new Scanner(System.in));
        int matchNmber = 0;

        for (String word : words) {
            if (word.matches("[0-9]+")
                    && new StringBuilder(word).reverse().toString().equals(word)) {
                if (++matchNmber == 2) {
                    System.out.println(word);
                }
            }
        }
    }

    @Override
    public void task9() {
        int size = new Scanner(System.in).nextInt();
        for (int row = 0; row < size; ++row) {
            for (int col = 0; col < size; ++col) {
                int element = row * size + col + 1;
                System.out.printf("%d ", element);
            }
            System.out.println();
        }
    }

    @Override
    public void task10() {
        Scanner scanner = new Scanner(System.in);
        int coefA = scanner.nextInt();
        int coefB = scanner.nextInt();
        int coefC = scanner.nextInt();
        double det = coefB * coefB - 4 * coefA * coefC;

        if (det < 0) {
            System.out.println("No solution");
            return;
        }

        double sqrtDet = Math.sqrt(det);

        if (det == 0) {
            double solution = (sqrtDet - coefB) / (2 * coefA);
            System.out.printf("One solution: %f\n", solution);
            return;
        }

        double solutionA = (-coefB - sqrtDet) / (2 * coefA);
        double solutionB = (-coefB + sqrtDet) / (2 * coefA);
        // TODO: Get rid of trailing zeroes
        System.out.printf("Two solutions: %f, %f\n", solutionA, solutionB);
    }

    @Override
    public void task11() {
        int monthIndex = new Scanner(System.in).nextInt();
        String monthName = "???";

        switch (monthIndex) {
            case 1:
                monthName = "January";
                break;
            case 2:
                monthName = "February";
                break;
            case 3:
                monthName = "March";
                break;
            case 4:
                monthName = "April";
                break;
            case 5:
                monthName = "May";
                break;
            case 6:
                monthName = "June";
                break;
            case 7:
                monthName = "July";
                break;
            case 8:
                monthName = "August";
                break;
            case 9:
                monthName = "September";
                break;
            case 10:
                monthName = "October";
                break;
            case 11:
                monthName = "November";
                break;
            case 12:
                monthName = "December";
                break;
            default:
                monthName = "INCORRECT INPUT DATA";
                break;
        }

        System.out.println(monthName);
    }

    @Override
    public void task12() {
        Scanner scanner = new Scanner(System.in);
        int column = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);

        Arrays.asList(matrix).sort(Comparator.comparing((int[] row) -> row[column]));

        System.out.println(matrix.length);
        for (int row = 0; row < matrix.length; ++row) {
            for (int col = 0; col < matrix[row].length; ++col) {
                System.out.printf("%d ", matrix[row][col]);
            }
            System.out.println();
        }
    }

    @Override
    public void task13() {
        Scanner scanner = new Scanner(System.in);
        int offset = scanner.nextInt();
        int[][] matrix = readMatrix(scanner);
        int matrixSize = matrix.length;
        int[][] newMatrix = new int[matrixSize][];

        offset = (offset % matrixSize + matrixSize) % matrixSize;
        for (int i = 0; i < matrixSize; ++i) {
            int shifted = (i + offset) % matrixSize;
            newMatrix[shifted] = matrix[i];
        }
        matrix = newMatrix;

        for (int[] row : matrix) {
            for (int val : row) {
                System.out.printf("%d ", val);
            }
            System.out.println();
        }
    }

    @Override
    public void task14() {

    }

    @Override
    public void task15() {

    }

    @Override
    public void task16() {

    }

    @Override
    public void task17() {

    }

    @Override
    public void task18() {

    }

    @Override
    public void task19() {

    }

    @Override
    public void task20() {

    }

    @Override
    public void task21() {

    }

    @Override
    public void task22() {

    }

    @Override
    public void task23() {

    }

    @Override
    public void task24() {

    }

    @Override
    public void task25() {

    }

    @Override
    public void task26() {

    }

    @Override
    public void task27() {

    }

    private List<String> readLines(Scanner scanner) {
        List<String> ret = new ArrayList<>();
        int count = scanner.nextInt();
        scanner.nextLine();

        for (int i = 0; i < count; ++i) {
            ret.add(scanner.nextLine());
        }

        return ret;
    }

    private List<String> readWords(Scanner scanner) {
        int count = scanner.nextInt();
        List<String> list = new ArrayList<>();
        for (int i = 0; i < count; ++i) {
            list.add(scanner.next());
        }
        return list;
    }

    private int[][] readMatrix(Scanner scanner) {
        int count = scanner.nextInt();
        int[][] mat = new int[count][count];
        for (int row = 0; row < count; ++row) {
            for (int col = 0; col < count; ++col) {
                mat[row][col] = scanner.nextInt();
            }
        }
        return mat;
    }
}
