package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение пятнадцатой задачи.
 *
 * Найти сумму элементов матрицы, расположенных между первым и вторым положительными элементами каждой строки.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.15">Задание №15</a>}
 */
public class Task15Test extends AbstractTaskTest {

    /** Шаблон проверки найденного количества */
    private static final Pattern PATTERN_FOUND_NUMBER = Pattern.compile("^\\-?\\d+$");

    /**
     * Проверяет совпадение найденной суммы с ожидаемым результатом.
     * @param expected Ожидаемое значение.
     * @param existing Полученное значение.
     */
    private void checkFoundSum(int expected, String existing) {
        if (!PATTERN_FOUND_NUMBER.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", expected, Integer.parseInt(existing));
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param matrix Исходная матрица.
     * @param sum Сумма искомых элементов.
     */
    private void test(SquareNumberMatrix<Integer> matrix, int sum) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(matrix.toString().getBytes());

            // Run
            SOLVER.task15();

            // Asserts
            this.checkFoundSum(sum, readOut.readLine());
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test
    public void test1() throws Exception {
        this.test(SquareIntMatrix.IDENTITY_MATRIX, 0);
    }

    /**
     * Матрица размерности 5, в каждой строке есть положительные элементы.
     */
    @org.junit.Test
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        { 2,   0,  3,  4,  5 },
                        { 1,   3,  0,  2, -1},
                        { 2,  -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   2,  4, -4,  3 }
                }), -6
        );
    }

    /**
     * Матрица размерности 3, нет положительных элементов.
     */
    @org.junit.Test
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        { 2,   0,  3,  4,  5 },
                        { 1,   3,  0,  2, -1},
                        { 2,  -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   2,  4, -4,  3 }
                }), -6
        );
    }
}