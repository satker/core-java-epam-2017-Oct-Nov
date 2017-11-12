package com.epam.courses.jf.practice.nbikbaev.first;

import com.epam.courses.jf.practice.common.first.ISolver;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Solver implements ISolver {

    @Override
    public void task1() {
        int n;
        String maxString = null;
        String minString = null;
        int minLength = 0;
        int maxLength = 0;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String strLine = in.readLine();
            n = Integer.valueOf(strLine);
            strLine = in.readLine();
            maxString = strLine;
            minString = strLine;
            for (int i = 0; i < n - 1; i++) {
                strLine = in.readLine();
                if (strLine.length() >= maxString.length()) {
                    maxString = strLine;
                }
                if (strLine.length() <= minString.length()) {
                    minString = strLine;
                }
            }
            minLength = minString.length();
            maxLength = maxString.length();
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.printf("MIN (%d): \"%s\"%n", minLength, minString);
        System.out.printf("MAX (%d): \"%s\"%n", maxLength, maxString);
    }

    @Override
    public void task2() {
        int n;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String strLine = in.readLine();
            n = Integer.valueOf(strLine);
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strings.add(in.readLine());
            }
            strings.sort((o1, o2) -> {
                int res = Integer.compare(o1.length(), o2.length());
                if (res == 0) {
                    return o1.compareTo(o2);
                }
                return res;
            });
            for (String s : strings) {
                System.out.printf("(%d): \"%s\"%n", s.length(), s);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void task3() {
        int n;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String strLine = in.readLine();
            n = Integer.valueOf(strLine);
            List<String> strings = new ArrayList<>();
            for (int i = 0; i < n; i++) {
                strings.add(in.readLine());
            }
            strings.sort(Comparator.comparingInt(String::length));
            int totalLength = 0;
            for (String s : strings) {
                totalLength += s.length();
            }
            int average = totalLength / n;
            System.out.printf("AVERAGE (%d)%n", average);
            for (String s : strings) {
                if (s.length() < average) {
                    System.out.printf("(%d): \"%s\"%n", s.length(), s);
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void task4() {
        int n;
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String strLine = in.readLine();
            n = Integer.valueOf(strLine);
            int min = Integer.MAX_VALUE;
            String minWord = null;
            strLine = in.readLine();
            String[] words = strLine.trim().split(" ");
            Set<Character> uniqKeys = new HashSet<>();
            for (int i = 0; i < n; i++) {
                for (int k = 0; k < words[i].length(); k++) {
                    uniqKeys.add(words[i].charAt(k));
                }
                if (uniqKeys.size() < min) {
                    min = uniqKeys.size();
                    minWord = words[i];
                }
                uniqKeys.clear();
            }
            System.out.println(minWord);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void task5() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            String sentence = in.readLine();
            Pattern vowelPattern = Pattern.compile("[AEIOUaeiou]");
            int k = 0;
            for (String word : sentence.trim().split(" ")) {
                if (word.matches("\\w+")) {
                    int vowelCount = 0;
                    Matcher vowelMatcher = vowelPattern.matcher(word);
                    while (vowelMatcher.find()) {
                        vowelCount++;
                    }
                    if (vowelCount * 2 == word.length()) {
                        k++;
                    }
                }
            }
            System.out.println(k);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unused")
    public void task6() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int k = 0;
            String result = null;
            int n = Integer.valueOf(in.readLine());
            String sentence = in.readLine();
            for (String word : sentence.trim().split(" ")) {
                if (word.length() == 1) {
                    continue;
                }
                if (Pattern.compile("(.)\\1+").matcher(word).find()) {
                    continue;
                }
                char[] letters = word.toCharArray();
                Arrays.sort(letters);
                String sortedWord = new String(letters);
                if (sortedWord.equals(word)) {
                    k++;
                    result = word;
                    if (k == 1) {
                        break;
                    }
                }
            }
            if (result != null) {
                System.out.println(result);
            } else {
                System.out.println("NOT FOUND");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unused")
    public void task7() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.valueOf(in.readLine());
            String[] words = in.readLine().trim().split(" ");
            Set<Character> wordSet = new HashSet<>();
            StringBuilder result = new StringBuilder();
            for (String word : words) {
                boolean flag = true;
                for (Character letter : word.toCharArray()) {
                    if (!wordSet.contains(letter)) {
                        wordSet.add(letter);
                    } else {
                        wordSet.clear();
                        flag = false;
                        break;
                    }
                }
                if (flag) {
                    result.append(word).append(" ");
                }
            }
            if (result.length() == 0) {
                System.out.println("NOT FOUND");
            }
            System.out.println(result.toString().trim());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("unused")
    public void task8() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            boolean palindromeExists = false;
            String result = null;
            int n = Integer.valueOf(in.readLine());
            String data = in.readLine();
            Pattern pattern = Pattern.compile("([0-9]+)");
            Matcher matcher = pattern.matcher(data);
            while (matcher.find()) {
                String s = matcher.group().trim();
                if (new StringBuilder(s).reverse().toString().equals(s)) {
                    result = s;
                    if (palindromeExists) {
                        break;
                    } else {
                        palindromeExists = true;
                    }
                }
            }
            if (result == null) {
                System.out.println("NOT FOUND");
            } else {
                System.out.println(result);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void task9() {
        try (BufferedReader in = new BufferedReader(new InputStreamReader(System.in))) {
            int n = Integer.valueOf(in.readLine());
            for (int i = 1; i <= n * n; i++) {
                System.out.print(i);
                if ((i % n) == 0) {
                    System.out.println();
                } else {
                    System.out.print("\t");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    @SuppressWarnings("deprecation")
    public void task10() {
        try (Scanner scanner = new Scanner(System.in);) {
            float a = scanner.nextInt();
            float b = scanner.nextInt();
            float c = scanner.nextInt();
            double discriminant = b * b - 4 * a * c;
            if (discriminant == 0) {
                float root = -b / 2 / a;
                BigDecimal rootBd = new BigDecimal(root)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);
                System.out.println("One solution: " + rootBd);
            } else if (discriminant < 0) {
                System.out.println("No solution");
            } else {
                double discriminantRoot = Math.sqrt(discriminant);
                double firstRoot = (-b + discriminantRoot) / 2 / a;
                double secondRoot = (-b - discriminantRoot) / 2 / a;

                BigDecimal firstRootBd = new BigDecimal(firstRoot)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);
                BigDecimal secondRootBd = new BigDecimal(secondRoot)
                        .setScale(2, BigDecimal.ROUND_HALF_UP);

                System.out.println("Two solutions: " + secondRootBd + "," + firstRootBd);
            }
        }

    }

    @Override
    public void task11() {
        try (Scanner scanner = new Scanner(System.in);) {
            String dataIn = scanner.nextLine();
            int month = 0;
            try {
                month = Integer.valueOf(dataIn);
            } catch (RuntimeException e) {
                System.out.println("INCORRECT INPUT DATA");
                return;
            }

            switch (month) {
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
            }
        }
    }

    @Override
    public void task12() {
        try (Scanner scanner = new Scanner(System.in)) {
            final int columnNumber = scanner.nextInt();
            int dimension = scanner.nextInt();
            int[][] matrix = Utils.readIntMatrix(scanner, dimension);
            Arrays.sort(matrix, (o1, o2) -> {
                Integer numOfKeys1 = o1[columnNumber];
                Integer numOfKeys2 = o2[columnNumber];
                return numOfKeys1.compareTo(numOfKeys2);
            });
            System.out.println(dimension);
            Utils.printIntMatrix(matrix, dimension, System.out);
        }
    }

    @Override
    public void task13() {
        try (Scanner scanner = new Scanner(System.in)) {
            int shift = scanner.nextInt();
            int shiftAbs = Math.abs(shift);
            int dimension = scanner.nextInt();
            int[][] matrix = Utils.readIntMatrix(scanner, dimension);
            if (shiftAbs == dimension) {
                System.out.println(dimension);
                Utils.printIntMatrix(matrix, dimension, System.out);
            } else {
                shiftAbs = (shiftAbs < dimension) ? shiftAbs : shiftAbs % dimension;
                if (shift < 0) {
                    Utils.matrixUpShift(matrix, shiftAbs, dimension);
                } else {
                    Utils.matrixDownShift(matrix, shiftAbs, dimension);
                }
                System.out.println(dimension);
                Utils.printIntMatrix(matrix, dimension, System.out);
            }
        }
    }

    @Override
    public void task14() {//2 1 3 3 4 5 6 5   //0 6 5 4 3 2 1 0 -1
        try (Scanner scanner = new Scanner(System.in)) {
            int n = scanner.nextInt();
            int maxLength = 0;
            int startPosition = 0;
            int[] data = new int[n];
            for (int i = 0; i < n; i++) {
                data[i] = scanner.nextInt();
            }
            for (int i = 0; i < n - 1; i++) {
                if (data[i] > data[i + 1]) {
                    int currentPosition = i + 1;
                    int length = currentPosition - startPosition;
                    if ((length > 1 && length > maxLength)) {
                        maxLength = length;
                    }
                    startPosition = i + 1;
                } else if (i == (n - 2) && startPosition == 0) {
                    maxLength = n;
                }
            }
            System.out.println(maxLength);
        }
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
}
