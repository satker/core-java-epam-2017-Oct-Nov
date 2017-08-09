package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение двадцать четвертой задачи.
 *
 * Перестроить матрицу, переставляя в ней строки так, чтобы сумма элементов в строках полученной матрицы возрастала.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.24">Задание №24</a>}
 */
public class Task24Test extends AbstractTaskTest {

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param original Исходная матрица.
     * @param transformed Преобразованная матрица.
     */
    private void test(SquareNumberMatrix<Integer> original, SquareNumberMatrix<Integer> transformed) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(original.toString().getBytes());

            // Run
            SOLVER.task24();

            // Asserts
            super.assertEquals("Incorrect result", transformed, SquareIntMatrix.parse(readOut));
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
     * Матрица размерности 4.
     * Сумма каждой строки различна, перестановки не требуются.
     */
    @org.junit.Test
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                { -4, -4,  0,  2 },
                {  2,  1, -1, -1 },
                {  4,  3,  3, -2 },
                {  2,  4,  3,  1 }
        }), new SquareIntMatrix(new Integer[][] {
                { -4, -4,  0,  2 },
                {  2,  1, -1, -1 },
                {  4,  3,  3, -2 },
                {  2,  4,  3,  1 }
        }));
    }

    /**
     * Матрица размерности 4.
     * Сумма каждой строки различна, требуются перестановки.
     */
    @org.junit.Test
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                {  2,  1, -1, -1 },
                { -4, -4,  0,  2 },
                {  2,  4,  3,  1 },
                {  4,  3,  3, -2 }
        }), new SquareIntMatrix(new Integer[][] {
                { -4, -4,  0,  2 },
                {  2,  1, -1, -1 },
                {  4,  3,  3, -2 },
                {  2,  4,  3,  1 }
        }));
    }

    /**
     * Матрица размерности 4.
     * Суммы двух строк одинаковы, требуются перестановки.
     */
    @org.junit.Test
    public void test4() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                {  2,  1, -1, -1 },
                { -4, -4,  0,  2 },
                {  2,  4,  3,  1 },
                {  4,  3,  3,  0 }
        }), new SquareIntMatrix(new Integer[][] {
                { -4, -4,  0,  2 },
                {  2,  1, -1, -1 },
                {  2,  4,  3,  1 },
                {  4,  3,  3,  0 }
        }));
    }
}