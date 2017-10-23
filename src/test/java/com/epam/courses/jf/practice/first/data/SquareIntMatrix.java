package com.epam.courses.jf.practice.first.data;

import org.junit.Assert;

import java.io.Reader;
import java.util.Scanner;

/**
 * Квадратная матрица целых чисел.
 */
public class SquareIntMatrix extends SquareNumberMatrix<Integer> {

    /** Singleton-объект единичной матрицы */
    public static final SquareIntMatrix IDENTITY_MATRIX = new SquareIntMatrix(new Integer[][] {{ 1 }});

    public SquareIntMatrix(Integer[][] data) {
        super(data);
    }

    /**
     * Восстанавливает объект матрицы из входного потка.
     * @param reader Входной поток.
     * @return Восстановленный объект.
     */
    public static SquareIntMatrix parse(Reader reader) {
        Scanner scanner = new Scanner(reader);
        final int dimension = scanner.nextInt();
        Integer[][] data = new Integer[dimension][dimension];
        for (int row = 0; row < dimension; ++row) {
            for (int column = 0; column < dimension; ++column) {
                if (!scanner.hasNextInt()) {
                    Assert.fail("Malformed matrix: " + scanner.next());
                }
                data[row][column] = scanner.nextInt();
            }
        }
        return new SquareIntMatrix(data);
    }
}
