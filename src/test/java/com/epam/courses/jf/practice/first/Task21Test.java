package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение двадцать первой задачи.
 *
 * Преобразовать строки матрицы таким образом, чтобы элементы, равные нулю, располагались после всех остальных.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.21">Задание №21</a>}
 */
public class Task21Test extends AbstractTaskTest {

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
            SOLVER.task21();

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
     * Элементы равные нулю отсутствуют.
     */
    @org.junit.Test
    public void test2() throws Exception {
        SquareNumberMatrix<Integer> matrix = new SquareIntMatrix(new Integer[][]{
                { -2, -4,  1, 2  },
                {  2,  4, -1, 1  },
                {  2,  1,  3, 1  },
                {  4,  3,  2, -1 }
        });
        this.test(matrix, matrix);
    }

    /**
     * Матрица размерности 4.
     * В различных строках присутствуют элементы равные нулю.
     */
    @org.junit.Test
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                {  2,  4, 2,  1 },
                {  2,  0, 0,  1 },
                {  4,  3, 3, -1 },
                { -2, -4, 0,  2 }
        }), new SquareIntMatrix(new Integer[][] {
                {  2,  4, 2,  1 },
                {  2,  1, 0,  0 },
                {  4,  3, 3, -1 },
                { -2, -4, 2,  0 }
        }));
    }

    /**
     * Матрица размерности 4.
     * Две строки заполнены полностью нулями.
     */
    @org.junit.Test
    public void test4() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                { 0, 4, 2,  1 },
                { 0, 0, 0,  0 },
                { 4, 3, 3, -1 },
                { 0, 0, 0,  0 }
        }), new SquareIntMatrix(new Integer[][] {
                { 4, 2, 1,  0 },
                { 0, 0, 0,  0 },
                { 4, 3, 3, -1 },
                { 0, 0, 0,  0 }
        }));
    }
}