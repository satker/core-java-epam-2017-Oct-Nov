package com.epam.courses.jf.practice.first;

import org.junit.Assert;
import com.epam.courses.jf.practice.first.data.*;

import java.io.IOException;
import java.util.regex.Pattern;

/**
 * Проверяет выполнение двадцать третьей задачи.
 *
 * Найти количество всех седловых точек матрицы.
 * Матрица А имеет седловую точку (i, j), если А[i, j] является минимальным элементом в i-й строке и максимальным в j-м столбце.
 *
 * {@see <a href="https://bitbucket.org/elefus/spring-java-school-epam-2016/wiki/Task%201.23">Задание №23</a>}
 */
public class Task23Test extends AbstractTaskTest {

    /** Шаблон проверки найденного количества */
    private static final Pattern PATTERN_FOUND_NUMBER = Pattern.compile("^\\d+$");

    /**
     * Проверяет совпадение найденного количества с ожидаемым результатом
     * @param expected Ожидаемое значение
     * @param existing Полученное значение
     */
    private void checkFoundNumber(int expected, String existing) {
        if (!PATTERN_FOUND_NUMBER.matcher(existing).matches()) {
            Assert.fail("The result is malformed: " + existing);
        }
        super.assertEquals("Incorrect result!", String.valueOf(expected), existing);
    }

    /**
     * Производит тестирование задачи с указанными исходными данными.
     * @param matrix Анализируемая матрица.
     * @param numberSaddlePoint Количество седловых точек.
     */
    private void test(SquareNumberMatrix<Integer> matrix, int numberSaddlePoint) throws IOException {
        try (DecoratorIO decoratorIO = new DecoratorIO()) {
            // Prepare
            super.setupStreams(decoratorIO);
            writeIn.write(matrix.toString().getBytes());

            // Run
            SOLVER.task23();

            // Asserts
            this.checkFoundNumber(numberSaddlePoint, readOut.readLine());
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
     * Матрица размерности 4.
     * Присутствует одна седловая точка (0).
     */
    @org.junit.Test (timeout = 2000)
    public void test2() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                { 4,   0,  1,  2 },
                { 2,  -1, -1,  1 },
                { 2,  -2,  3,  1 },
                { 4,  -1,  2, -1 }
        }), 1);
    }

    /**
     * Матрица размерности 4.
     * Седловые точки отсутствуют.
     */
    @org.junit.Test (timeout = 2000)
    public void test3() throws Exception {
        this.test(new SquareIntMatrix(new Integer[][]{
                { 4,   2,  1,  2 },
                { 2,  -1, -2,  1 },
                { 2,  -2,  3,  1 },
                { 4,  -1,  2, -1 }
        }), 0);
    }
}