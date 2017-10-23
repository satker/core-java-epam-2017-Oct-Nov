package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение двенадцатой задачи.
 *
 * Упорядочить строки матрицы размерности N в порядке возрастания значений элементов k-го столбца.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.12">Задание №12</a>}
 */
public class Task12Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param numberColumn Индекс столбца, по которому производится сортировка.
     * @param original Исходная матрица.
     * @param transformed Модифицированная матрица.
     */
    private void test(int numberColumn, SquareNumberMatrix<Integer> original, SquareNumberMatrix<Integer> transformed) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(String.format("%d%n%s", numberColumn, original).getBytes());

            // Run
            SOLVER.task12();

            // Asserts
            super.assertEquals("Incorrect result", transformed, SquareIntMatrix.parse(readOut));
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(0, SquareIntMatrix.IDENTITY_MATRIX, SquareIntMatrix.IDENTITY_MATRIX);
    }

    /**
     * Матрица размерности 5.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(2, new SquareIntMatrix(new Integer[][] {
                        { 0,   2,  3,  4,  5 },
                        { 1,   3,  0,  2, -1},
                        { -1, -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   3, -3, -4,  3 }
                }), new SquareIntMatrix(new Integer[][] {
                        { -1, -1, -5,  5,  0},
                        {  5,  4, -4, -2,  2},
                        {  1,  3, -3, -4,  3 },
                        {  1,  3,  0,  2, -1},
                        {  0,  2,  3,  4,  5 }
                })
        );
    }
}