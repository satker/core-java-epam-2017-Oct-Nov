package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение семнадцатой задачи.
 *
 * Вычислить определитель матрицы.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.17">Задание №17</a>}
 */
public class Task17Test extends AbstractTaskTest {

    /** Шаблон проверки найденного определителя */
    private static final Pattern PATTERN_FOUND_DETERMINANT = Pattern.compile("^\\-?\\d+$");

    /**
     * Проверяет совпадение найденной суммы с ожидаемым результатом.
     * @param determinant Ожидаемое значение определителя.
     * @param existing Полученное значение.
     */
    private void checkFoundDeterminant(int determinant, String existing) {
        if (!PATTERN_FOUND_DETERMINANT.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", determinant, Integer.parseInt(existing));
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param matrix Исходная матрица.
     * @param determinant Определитель матрицы.
     */
    private void test(SquareNumberMatrix<Integer> matrix, int determinant) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(matrix.toString().getBytes());

            // Run
            SOLVER.task17();

            // Asserts
            this.checkFoundDeterminant(determinant, readOut.readLine());
        }
    }

    /**
     * Единичная матрица.
     */
    @org.junit.Test (timeout = 2000)
    public void test1() throws Exception {
        this.test(SquareIntMatrix.IDENTITY_MATRIX, 1);
    }

    /**
     * Матрица размерности 2.
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        { 1, 0 },
                        { 0, 1}
                }), 1
        );
    }

    /**
     * Матрица размерности 5.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][] {
                        { 2,   0,  3,  4,  5 },
                        { 1,   3,  0,  2, -1},
                        { 2,  -1, -5,  5,  0},
                        { 5,   4, -4, -2,  2},
                        { 1,   2,  4, -4,  3 }
                }), -105
        );
    }
}