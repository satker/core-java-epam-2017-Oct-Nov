package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение двадцать второй задачи.
 *
 * Округлить все элементы матрицы до целого числа.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.22">Задание №22</a>}
 */
public class Task22Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param original Исходная матрица вещественных чисел.
     * @param transformed Преобразованная матрица целых чисел.
     */
    private void test(SquareNumberMatrix<Double> original, SquareNumberMatrix<Integer> transformed) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(original.toString().getBytes());

            // Run
            SOLVER.task22();

            // Asserts
            super.assertEquals("Incorrect result", transformed, SquareIntMatrix.parse(readOut));
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test
    public void test1() throws Exception {
        this.test(new SquareDoubleMatrix(new Double[][]{{0.999}}), SquareIntMatrix.IDENTITY_MATRIX);
    }

    /**
     * Матрица размерности 4.
     * Требуется округление элементов как в большую, так и в меньшую сторону.
     */
    @org.junit.Test
    public void test2() throws Exception {
        this.test(new SquareDoubleMatrix(new Double[][] {
                {  2.0,  4.0,  2.6,  1.0 },
                {  2.0,  0.9, -0.9, -1.0 },
                {  3.9,  3.1,  3.2, -1.8 },
                { -3.7, -4.0,  0.0,  2.0 }
        }), new SquareIntMatrix(new Integer[][] {
                {  2,  4,  3,  1 },
                {  2,  1, -1, -1 },
                {  4,  3,  3, -2 },
                { -4, -4,  0,  2 }
        }));
    }
}