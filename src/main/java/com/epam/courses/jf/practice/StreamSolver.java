package com.epam.courses.jf.practice;

import java.util.Comparator;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

/**
 * Реализация первого практического задания с использованием Stream-API.
 */
@SuppressWarnings("unused")
public class StreamSolver {

    public void task1() {
        Scanner scanner = new Scanner(System.in);
        int countLines = Integer.valueOf(scanner.nextLine());

        String minimal = scanner.nextLine();
        String maximal = minimal;
        for (int i = 1; i < countLines; ++i) {
            String current = scanner.nextLine();
            if (minimal.length() >= current.length()) {
                minimal = current;
            }
            if (maximal.length() <= current.length()) {
                maximal = current;
            }
        }
        System.out.printf("MIN (%d): \"%s\"%n", minimal.length(), minimal);
        System.out.printf("MAX (%d): \"%s\"%n", maximal.length(), maximal);
    }

    private static Stream<String> readWordsAsStream() {
        Scanner scanner = new Scanner(System.in);
        return IntStream.range(0, Integer.valueOf(scanner.nextLine()))
                        .mapToObj(i -> scanner.next());
    }

    private static Stream<String> readLinesAsStream() {
        Scanner scanner = new Scanner(System.in);
        return IntStream.range(0, Integer.valueOf(scanner.nextLine()))
                        .mapToObj(i -> scanner.nextLine());
    }

    private static String[] readLinesAsArray() {
        return readLinesAsStream().toArray(String[]::new);
    }

    public void task2() {
        readLinesAsStream().sorted((l, r) -> l.length() - r.length() == 0 ? l.compareTo(r) : l.length() - r.length())
                           .forEach(string -> System.out.printf("(%d): \"%s\"%n", string.length(), string));
    }

    public void task3() {
        String[] lines = readLinesAsArray();

        int averageLength = (int) Stream.of(lines)
                                        .mapToInt(String::length)
                                        .average()
                                        .orElseThrow(AssertionError::new);
        System.out.printf("AVERAGE (%d)%n", averageLength);

        Stream.of(lines)
              .filter(string -> string.length() < averageLength)
              .forEachOrdered(string -> System.out.printf("(%d): \"%s\"%n", string.length(), string));
    }

    public void task4() {
        System.out.println(readWordsAsStream().min(Comparator.comparingLong(other -> other.chars().distinct().count()))
                                              .orElseThrow(AssertionError::new));
    }

    public void task5() {
        System.out.println(readWordsAsStream().filter(string -> Pattern.matches("[A-Za-z]+", string))
                                              .filter(StreamSolver::isEqualsVowelsAndConsonants)
                                              .count());
    }

    /**
     * @param string Анализируемая строка.
     * @return Содержит равное количество гласных и согласных букв.
     */
    private static boolean isEqualsVowelsAndConsonants(String string) {
        return string.length() % 2 == 0
            && string.length() / 2 == string.replaceAll("[AEIOUaeiou]", "").length();
    }

    public void task6() {
        System.out.println(readWordsAsStream().filter(StreamSolver::containIncreasingSymbols)
                .findFirst()
                .orElse("NOT FOUND"));
    }

    /**
     * @param string Анализируемая строка.
     * @return Символы строки строго возрастают.
     */
    private static boolean containIncreasingSymbols(String string) {
        return string.length() > 1
            && string.chars()
                     .reduce((left, right) -> left < 0 ? -1 : (right > left ? right : -1))
                     .orElse(-1) >= 0;
    }

    public void task7() {
        String result = readWordsAsStream().filter(string -> string.chars().distinct().count() == string.length())
                                           .distinct()
                                           .collect(Collectors.joining(" "));
        System.out.println(result.isEmpty() ? "NOT FOUND" : result);
    }

    public void task8() {
        String[] palindromes = readWordsAsStream().filter(StreamSolver::isNumericPalindrome).toArray(String[]::new);
        System.out.println(palindromes.length == 1 ? palindromes[0]
                                                   : palindromes.length >= 2 ? palindromes[1]
                                                                             : "NOT FOUND");
    }

    /**
     * @param string Анализируемая строка.
     * @return Является числовым палиндромом.
     */
    private static boolean isNumericPalindrome(String string) {
        for (int i = 0; i < string.length(); ++i) {
            char left = string.charAt(i);
            char right = string.charAt(string.length() - 1 - i);
            if (!Character.isDigit(left) || !Character.isDigit(right) || left != right) {
                return false;
            }
        }
        return true;
    }

    public void task9() {
        final int N = new Scanner(System.in).nextInt();
        System.out.println(IntStream.range(1, N * N + 1)
                                    .mapToObj(i -> i + (i % N == 0 ? "\n" : "\t"))
                                    .collect(Collectors.joining()));
    }
}