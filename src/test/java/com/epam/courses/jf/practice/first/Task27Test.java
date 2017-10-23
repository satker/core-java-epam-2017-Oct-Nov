package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;

/**
 * Проверяет выполнение двадцать седьмой задачи.
 *
 * Перестроить заданную матрицу, переставляя в ней столбцы так, чтобы значения их характеристик убывали.
 * Характеристикой столбца прямоугольной матрицы называется сумма модулей его элементов.
 * Если значения характеристики совпадают - столбцы должны следовать в том же порядке, что и в исходной матрице.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.27">Задание №27</a>}
 */
public class Task27Test extends AbstractTaskTest {

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
            SOLVER.task27();

            // Asserts
            super.assertEquals("Incorrect result", transformed, SquareIntMatrix.parse(readOut));
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
     * Матрица размерности 2.
     * Изменения не требуются.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                { -1, -2 },
                {  2,  1 }
        }), new SquareIntMatrix(new Integer[][] {
                { -1, -2 },
                {  2,  1 }
        }));
    }

    /**
     * Матрица размерности 4.
     * Требуется перестановка всех столбцов.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                {  0, 0, 0, 0 },
                {  0, 0, 0, 0 },
                {  0, 0, 0, 0 },
                {  0, 1, 2, 3 }
        }), new SquareIntMatrix(new Integer[][] {
                {  0, 0, 0, 0 },
                {  0, 0, 0, 0 },
                {  0, 0, 0, 0 },
                {  3, 2, 1, 0 }
        }));
    }

    /**
     * Матрица размерности 4.
     * Требуется перестановка крайних столбцов.
     */
    @org.junit.Test (timeout = 2000)
    public void test4() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                {  0, 0, 0, 0 },
                {  0, 0, 0, 0 },
                {  0, 0, 0, 0 },
                {  0, 2, 1, 3 }
        }), new SquareIntMatrix(new Integer[][] {
                {  0, 0, 0, 0 },
                {  0, 0, 0, 0 },
                {  0, 0, 0, 0 },
                {  3, 2, 1, 0 }
        }));
    }
}