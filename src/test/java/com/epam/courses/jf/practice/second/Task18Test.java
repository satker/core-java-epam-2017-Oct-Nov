package com.epam.courses.jf.practice.second;

import org.junit.Assert;
import com.epam.courses.jf.practice.common.second.ITestableTask18;

import java.util.Arrays;

import static com.epam.courses.jf.practice.common.second.ITestableTask18.IRectangularIntegerMatrix;

/**
 * Проверяет выполнение восемнадцатой задачи.
 *
 * Дана матрица из целых чисел.
 * Найти в ней прямоугольную подматрицу, состоящую из максимального количества одинаковых элементов.
 * Использовать стек.
 */
public class Task18Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param matrix Исходная матрица.
     * @param expected Ожидаемый результат.
     */
    public void test(IRectangularIntegerMatrix matrix, IRectangularIntegerMatrix expected) throws Exception {
        // Prepare
        ITestableTask18 solver = TASK_STORAGE.getSolver(ITestableTask18.class);

        // Run
        IRectangularIntegerMatrix result = solver.getMaxSubMatrix(matrix);

        // Asserts
        Assert.assertEquals(expected, result);
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        IRectangularIntegerMatrix identity = new RectangularIntegerMatrix(new int[][] {{1}});
        test(identity, identity);
    }

    /**
     * Матрица 2х2 с подматрицей из двух элементов.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        test(new RectangularIntegerMatrix(new int[][] {{1, 1}, {2, 3}}), new RectangularIntegerMatrix(new int[][] {{1, 1}}));
    }

    /**
     * Матрица 3x3 с максимальной горизонтальной подматрицей 3х2.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        test(new RectangularIntegerMatrix(new int[][] {{1, 1, 1}, {1, 1, 1}, {2, 2, 2}}),
             new RectangularIntegerMatrix(new int[][] {{1, 1, 1}, {1, 1, 1}}));
    }

    /**
     * Матрица 3x3 с максимальной вертикальной подматрицей 2х3.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        test(new RectangularIntegerMatrix(new int[][] {{1, 1, 2}, {1, 1, 2}, {1, 1, 2}}),
             new RectangularIntegerMatrix(new int[][] {{1, 1}, {1, 1}, {1, 1}}));
    }

    private class RectangularIntegerMatrix implements IRectangularIntegerMatrix {

        private final int[][] DATA;

        public RectangularIntegerMatrix(int[][] DATA) {
            this.DATA = Arrays.copyOf(DATA, DATA.length);
        }

        @Override
        public int getWidth() {
            return DATA[0].length;
        }

        @Override
        public int getHeight() {
            return DATA.length;
        }

        @Override
        public int getValue(int indexWidth, int indexHeight) {
            return DATA[indexHeight][indexWidth];
        }

        @Override
        public boolean equals(Object other) {
            if (this == other) return true;
            if (other == null || !(other instanceof IRectangularIntegerMatrix)) return false;
            IRectangularIntegerMatrix matrix = (IRectangularIntegerMatrix) other;
            if (getHeight() != matrix.getHeight() || getWidth() != matrix.getWidth()) {
                return false;
            }
            for (int row = 0; row < getHeight(); row++) {
                for (int col = 0; col < getWidth(); col++) {
                    if (getValue(col, row) != matrix.getValue(col, row)) {
                        return false;
                    }
                }
            }
            return true;
        }
    }
}