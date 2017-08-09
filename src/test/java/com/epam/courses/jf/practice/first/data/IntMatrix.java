package com.epam.courses.jf.practice.first.data;

import org.junit.Assert;

import java.io.*;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Прямоугольная матрица целых чисел.
 */
public class IntMatrix extends NumberMatrix<Integer> {

    /** Шаблон строки матрицы */
    public static final Pattern PATTERN_LINE = Pattern.compile("^(\\-?\\d+\\s)*\\-?\\d+$");

    public IntMatrix(Integer[][] data) {
        super(data);
    }

    /**
     * Восстанавливает объект матрицы из входного потка.
     * @param reader Входной поток.
     * @return Восстановленный объект.
     */
    public static IntMatrix parse(Reader reader) {
        Scanner scanner = new Scanner(reader);
        final int width = scanner.nextInt();
        final int height = scanner.nextInt();
        Integer[][] data = new Integer[width][height];
        for (int row = 0; row < width; ++row) {
            for (int column = 0; column < height; ++column) {
                if (!scanner.hasNextInt()) {
                    Assert.fail("Malformed matrix: " + scanner.next());
                }
                data[row][column] = scanner.nextInt();
            }
        }
        return new IntMatrix(data);
    }
}
