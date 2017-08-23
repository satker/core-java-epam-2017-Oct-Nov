package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение девятнадцатой задачи.
 *
 * Уплотнить матрицу, удаляя из нее строки и столбцы, заполненные нулями.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.19">Задание №19</a>}
 */
public class Task19Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param original Исходная матрица.
     * @param transformed Преобразованная матрица.
     */
    private void test(SquareNumberMatrix<Integer> original, NumberMatrix<Integer> transformed) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(original.toString().getBytes());

            // Run
            SOLVER.task19();

            // Asserts
            super.assertEquals("Incorrect result", transformed, IntMatrix.parse(readOut));
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(SquareIntMatrix.IDENTITY_MATRIX, SquareIntMatrix.IDENTITY_MATRIX);
    }

    /**
     * Матрица размерности 4 с одним "нулевым" столбцом.
     * В результате уплотнения получается прямоугольная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        {  4,  2, 0,  1 },
                        {  0,  2, 0,  1 },
                        {  3,  4, 0, -1 },
                        { -4, -2, 0,  2 }
                }), new IntMatrix(new Integer[][] {
                        {  4,  2,  1 },
                        {  0,  2,  1 },
                        {  3,  4, -1 },
                        { -4, -2,  2 }
                })
        );
    }

    /**
     * Матрица размерности 4 с одним "нулевым" столбцом и двумя "нулевыми" строками.
     * В результате уплотнения получается прямоугольная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        { 4, 2, 0,  1 },
                        { 0, 0, 0,  0 },
                        { 3, 4, 0, -1 },
                        { 0, 0, 0,  0 }
                }), new IntMatrix(new Integer[][] {
                        {  4,  2,  1 },
                        {  3,  4, -1 }
                })
        );
    }
}