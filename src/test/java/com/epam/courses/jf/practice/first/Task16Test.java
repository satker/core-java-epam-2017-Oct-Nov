package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение шестнадцатой задачи.
 *
 * Повернуть матрицу на 90 градусов против часовой стрелки.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.16">Задание №16</a>}
 */
public class Task16Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param original Исходная матрица.
     * @param rotated Матрица, повернутая на 90 градусов.
     */
    private void test(SquareNumberMatrix<Integer> original, SquareNumberMatrix<Integer> rotated) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(original.toString().concat("\n").getBytes());

            // Run
            SOLVER.task16();

            // Asserts
            super.assertEquals("Incorrect result", rotated, SquareIntMatrix.parse(readOut));
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test
    public void test1() throws Exception {
        this.test(SquareIntMatrix.IDENTITY_MATRIX, SquareIntMatrix.IDENTITY_MATRIX);
    }

    /**
     * Матрица размерности 5.
     */
    @org.junit.Test
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        {  0,  2,  3,  4,  5 },
                        {  1,  3,  0,  2, -1 },
                        { -1, -1, -5,  5,  0 },
                        {  5,  4, -4, -2,  2 },
                        {  1,  3, -3, -4,  3 }
                }), new SquareIntMatrix(new Integer[][] {
                        { 5, -1,  0,  2,  3 },
                        { 4,  2,  5, -2, -4 },
                        { 3,  0, -5, -4, -3 },
                        { 2,  3, -1,  4,  3 },
                        { 0,  1, -1,  5,  1 }
                })
        );
    }
}